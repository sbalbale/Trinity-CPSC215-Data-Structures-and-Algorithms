package edu.trincoll.part2;

/**
 * A generic HashTable implementation using double hashing for collision
 * resolution.
 * 
 * @param <K> the type of keys maintained by this hash table
 * @param <V> the type of mapped values
 */
public class HashTable<K, V> {
    private int size; // Current number of elements in the hash table
    private int capacity; // Maximum capacity of the hash table
    private Entry<K, V>[] table; // Array to store key-value pairs

    /**
     * Constructs a HashTable with the specified capacity.
     * 
     * @param capacity the maximum number of elements the hash table can hold
     */
    public HashTable(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.table = new Entry[capacity]; // Initialize the table array
    }

    /**
     * Hash function 1: Computes the hash value using the formula h1(x) = x %
     * capacity.
     * 
     * @param key the key to hash
     * @return the hash value
     */
    private int hashFunction1(K key) {
        return Math.abs((key.hashCode()) % capacity);
    }

    /**
     * Hash function 2: Computes the step size using the formula h2(key) = 7 −
     * (abs(h1(key)) % 7).
     * 
     * @param key the key to hash
     * @return the step size
     */
    private int hashFunction2(K key) {
        int prime = 7; // A prime number less than the table size
        return prime - (Math.abs(hashFunction1(key)) % prime);
    }

    /**
     * Double hashing function: Combines hashFunction1 and hashFunction2 to resolve
     * collisions.
     * 
     * @param key the key to hash
     * @param i   the current probe number
     * @return the computed index
     */
    private int doubleHash(K key, int i) {
        return (hashFunction1(key) + i * hashFunction2(key)) % capacity;
    }

    /**
     * Inserts a key-value pair into the hash table. If the key already exists,
     * updates its value.
     * 
     * @param key   the key to insert
     * @param value the value to associate with the key
     */
    public void put(K key, V value) {
        if (size >= capacity) { // Check if the table is full
            System.out.println("Hash table is full");
            return;
        }

        int i = 0; // Probe counter
        int index;
        while (i < capacity) { // Iterate until a free slot is found
            index = doubleHash(key, i); // Compute the index using double hashing
            if (table[index] == null || table[index].deleted) { // Empty or deleted slot
                table[index] = new Entry<>(key, value); // Insert the key-value pair
                size++; // Increment the size
                return;
            } else if (table[index].key.equals(key)) { // Key already exists
                table[index].value = value; // Update the value
                return;
            }
            i++; // Increment the probe counter
        }
    }

    /**
     * Retrieves the value associated with the specified key.
     * 
     * @param key the key to search for
     * @return the value associated with the key, or null if the key is not found
     */
    public V get(K key) {
        int i = 0; // Probe counter
        int index;
        while (i < capacity) { // Iterate through the table
            index = doubleHash(key, i); // Compute the index using double hashing
            if (table[index] == null) { // Empty slot
                return null; // Key not found
            } else if (table[index].key.equals(key) && !table[index].deleted) { // Key found
                return table[index].value; // Return the value
            }
            i++; // Increment the probe counter
        }
        return null; // Key not found
    }

    /**
     * Removes the key-value pair associated with the specified key.
     * 
     * @param key the key to remove
     */
    public void remove(K key) {
        int i = 0; // Probe counter
        int index;
        while (i < capacity) { // Iterate through the table
            index = doubleHash(key, i); // Compute the index using double hashing
            if (table[index] == null) { // Empty slot
                return; // Key not found
            } else if (table[index].key.equals(key) && !table[index].deleted) { // Key found
                table[index].deleted = true; // Mark the entry as deleted
                size--; // Decrement the size
                return;
            }
            i++; // Increment the probe counter
        }
        System.out.println("Key not found: " + key); // Key not found
    }

    /**
     * Prints the contents of the hash table.
     */
    public void print() {
        for (int i = 0; i < capacity; i++) { // Iterate through the table
            if (table[i] != null && !table[i].deleted) { // Non-empty and not deleted
                System.out.println("Index " + i + ": Key = " + table[i].key + ", Value = " + table[i].value);
            } else { // Empty or deleted slot
                System.out.println("Index " + i + ": null");
            }
        }
    }

    /**
     * Entry class to store key-value pairs in the hash table.
     * 
     * @param <K> the type of keys
     * @param <V> the type of values
     */
    private static class Entry<K, V> {
        K key; // The key
        V value; // The value
        boolean deleted; // Flag to indicate if the entry is deleted

        /**
         * Constructs an Entry with the specified key and value.
         * 
         * @param key   the key
         * @param value the value
         */
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.deleted = false; // Initially not deleted
        }
    }
}
