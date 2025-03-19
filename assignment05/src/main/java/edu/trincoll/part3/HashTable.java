package edu.trincoll.part3;

@SuppressWarnings("unchecked")
public class HashTable<Key, Value> {
    // Constants
    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR_THRESHOLD = 0.75;
    private static final double A = 0.618033988749895; // Golden ratio - 1

    // Hash function constants
    public static final int DIVISION_HASH = 1;
    public static final int MULTIPLICATION_HASH = 2;
    public static final int UNIVERSAL_HASH = 3;

    // Collision resolution constants
    public static final int LINEAR_PROBING = 1;
    public static final int QUADRATIC_PROBING = 2;
    public static final int DOUBLE_HASHING = 3;

    // Instance variables
    private int size; // Number of key-value pairs in the table
    private int capacity; // Current capacity of the table
    private Key[] keys; // Array to store keys
    private Value[] values; // Array to store values
    private boolean[] deleted; // Tombstone markers for deleted entries

    // Performance metrics
    private int collisions; // Total number of collisions
    private long totalProbeLength; // Sum of probe lengths for all operations
    private int probeCount; // Total number of probes

    // Hash function and collision resolution strategy
    private int hashFunction;
    private int collisionResolution;

    // For universal hashing
    private final int a;
    private final int b;
    private final int p = 2147483647; // A prime number (2^31 - 1)

    /**
     * Default constructor - initializes the hash table with default settings.
     */
    public HashTable() {
        // Default: Division hash and linear probing
        this(INITIAL_CAPACITY, DIVISION_HASH, LINEAR_PROBING);
    }

    /**
     * Constructor with specified capacity, hash function, and collision resolution strategy.
     * @param initialCapacity Initial capacity of the hash table.
     * @param hashFunction Hashing technique (1: Division, 2: Multiplication, 3: Universal).
     * @param collisionResolution Collision resolution strategy (1: Linear, 2: Quadratic, 3: Double Hashing).
     */
    @SuppressWarnings("unchecked")
    public HashTable(int initialCapacity, int hashFunction, int collisionResolution) {
        // For universal hashing
        a = 1 + (int) (Math.random() * (p - 1)); // Random parameter for universal hashing
        b = (int) (Math.random() * p);          // Random parameter for universal hashing
        
        // Use prime capacity for better distribution, especially for quadratic probing and double hashing
        capacity = (collisionResolution == QUADRATIC_PROBING || collisionResolution == DOUBLE_HASHING) 
                   ? nextPrime(initialCapacity) : initialCapacity;
        this.hashFunction = hashFunction;
        this.collisionResolution = collisionResolution;
        
        // Initialize arrays
        keys = (Key[]) new Object[capacity];
        values = (Value[]) new Object[capacity];
        deleted = new boolean[capacity];
        
        // Initialize performance metrics
        size = 0;
        collisions = 0;
        totalProbeLength = 0;
        probeCount = 0;
    }

    /**
     * Inserts a key-value pair into the hash table.
     * @param key The key to insert.
     * @param value The value associated with the key.
     */
    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        
        // Check if resize is needed
        if ((double) size / capacity >= LOAD_FACTOR_THRESHOLD) {
            resize(2 * capacity);
        }
        
        int probeLength = 0;
        int initialIndex = h(key);
        int i = 0;
        int index;
        
        // Probe until an empty slot or the key is found
        do {
            index = Math.abs((initialIndex + p(key, i)) % capacity);
            probeLength++;
            
            // If we find the key, update the value
            if (keys[index] != null && keys[index].equals(key) && !deleted[index]) {
                values[index] = value;
                updateMetrics(probeLength, 0); // No collision in this case
                return;
            }
            
            // If we find an empty slot or a tombstone, insert here
            if (keys[index] == null || deleted[index]) {
                keys[index] = key;
                values[index] = value;
                
                // Only increment size if it's a new entry (not overwriting a deleted entry)
                if (!deleted[index]) {
                    size++;
                } else {
                    deleted[index] = false; // Clear the tombstone
                }
                
                // If i > 0, it means we had a collision
                updateMetrics(probeLength, i > 0 ? 1 : 0);
                return;
            }
            
            // We had a collision
            i++;
        } while (i < capacity); // Prevent infinite loop
        
        // If we get here, the table is full or has too many collisions
        // This should be extremely rare due to resizing
        resize(capacity * 2); // Try resizing and inserting again
        put(key, value);
    }

    /**
     * Retrieves the value associated with the given key.
     * @param key The key to search for.
     * @return The value associated with the key, or null if not found.
     */
    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        
        int probeLength = 0;
        int initialIndex = h(key);
        int i = 0;
        int index;
        
        // Probe until we find the key, an empty slot, or we've checked the entire table
        do {
            index = Math.abs((initialIndex + p(key, i)) % capacity);
            probeLength++;
            
            // Empty slot (not deleted) means key is not in the table
            if (keys[index] == null && !deleted[index]) {
                updateMetrics(probeLength, 0);
                return null;
            }
            
            // Found the key
            if (keys[index] != null && keys[index].equals(key) && !deleted[index]) {
                updateMetrics(probeLength, 0);
                return values[index];
            }
            
            i++;
        } while (i < capacity && (keys[index] != null || deleted[index]));
        
        // Key not found
        updateMetrics(probeLength, 0);
        return null;
    }

    /**
     * Deletes a key-value pair from the hash table.
     * @param key The key to delete.
     */
    public void delete(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        
        int probeLength = 0;
        int initialIndex = h(key);
        int i = 0;
        int index;
        
        // Probe until we find the key, an empty slot, or we've checked the entire table
        do {
            index = Math.abs((initialIndex + p(key, i)) % capacity);
            probeLength++;
            
            // Empty slot (not deleted) means key is not in the table
            if (keys[index] == null && !deleted[index]) {
                updateMetrics(probeLength, 0);
                return;
            }
            
            // Found the key
            if (keys[index] != null && keys[index].equals(key) && !deleted[index]) {
                // Mark as deleted (tombstone)
                deleted[index] = true;
                size--;
                updateMetrics(probeLength, 0);
                return;
            }
            
            i++;
        } while (i < capacity && (keys[index] != null || deleted[index]));
        
        // Key not found
        updateMetrics(probeLength, 0);
    }

    /**
     * Primary hash function based on the selected hashing technique.
     * @param key The key to hash.
     * @return The hashed index within the range [0, capacity-1].
     */
    private int h(Key key) {
        int hash = Math.abs(key.hashCode());
        
        switch (hashFunction) {
            case DIVISION_HASH:
                return hash % capacity;
                
            case MULTIPLICATION_HASH:
                return (int) (capacity * ((hash * A) % 1));
                
            case UNIVERSAL_HASH:
                return ((a * hash + b) % p) % capacity;
                
            default:
                return hash % capacity;
        }
    }

    /**
     * Secondary hash function for double hashing.
     * @param key The key to hash.
     * @return A secondary hashed index within the range [1, capacity-1].
     */
    private int h2(Key key) {
        int hash = Math.abs(key.hashCode());
        // Make sure we return a value coprime to capacity (which should be prime)
        // to ensure the probing sequence covers all slots
        int secondHash = 1 + (hash % (capacity - 1));
        
        // Double check to make sure it's not 0
        return secondHash == 0 ? 1 : secondHash;
    }

    /**
     * Probing function based on the selected collision resolution strategy.
     * @param key The key being probed.
     * @param i The current probe number.
     * @return The offset to add to the initial hashed index.
     */
    private int p(Key key, int i) {
        switch (collisionResolution) {
            case LINEAR_PROBING:
                return i;
                
            case QUADRATIC_PROBING:
                return i * i;
                
            case DOUBLE_HASHING:
                return i * h2(key);
                
            default:
                return i;
        }
    }

    /**
     * Resizes the hash table when load factor exceeds a threshold.
     * @param newCapacity The new capacity of the table after resizing.
     */
    private void resize(int newCapacity) {
        // If using quadratic probing or double hashing, ensure the new capacity is prime
        if (collisionResolution == QUADRATIC_PROBING || collisionResolution == DOUBLE_HASHING) {
            newCapacity = nextPrime(newCapacity);
        }
        
        // Save old data
        Key[] oldKeys = keys;
        Value[] oldValues = values;
        boolean[] oldDeleted = deleted;
        int oldCapacity = capacity;
        
        // Initialize new arrays
        capacity = newCapacity;
        keys = (Key[]) new Object[capacity];
        values = (Value[]) new Object[capacity];
        deleted = new boolean[capacity];
        size = 0;
        
        // Re-insert all existing entries
        for (int i = 0; i < oldCapacity; i++) {
            if (oldKeys[i] != null && !oldDeleted[i]) {
                put(oldKeys[i], oldValues[i]);
            }
        }
    }

    /**
     * Updates performance metrics after an operation.
     * @param probeLength The length of the probe sequence for this operation.
     * @param collisionsInThisOp The number of collisions in this operation.
     */
    private void updateMetrics(int probeLength, int collisionsInThisOp) {
        totalProbeLength += probeLength;
        probeCount++;
        collisions += collisionsInThisOp;
    }

    /**
     * Returns the current load factor of the hash table (size / capacity).
     */
    public double getLoadFactor() {
        return (double) size / capacity;
    }

    /**
     * Returns the total number of collisions encountered during operations.
     */
    public int getCollisions() {
        return collisions;
    }

    /**
     * Returns the average probe length for all operations performed so far.
     */
    public double getAverageProbeLength() {
        return probeCount == 0 ? 0 : (double) totalProbeLength / probeCount;
    }

    /**
     * Resets all performance metrics to zero.
     */
    public void resetMetrics() {
        collisions = 0;
        totalProbeLength = 0;
        probeCount = 0;
    }

    /**
     * Finds the next prime number greater than or equal to n.
     * @param n The starting number.
     * @return The next prime number.
     */
    private int nextPrime(int n) {
        if (n <= 2) return 2;
        
        // Start with odd number to make search faster
        int candidate = n % 2 == 0 ? n + 1 : n;
        
        while (!isPrime(candidate)) {
            candidate += 2;
        }
        
        return candidate;
    }

    /**
     * Checks if a number is prime.
     * @param n The number to check.
     * @return True if the number is prime, false otherwise.
     */
    private boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        
        // Check all factors of form 6k±1 up to sqrt(n)
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        
        return true;
    }
}
