package edu.trincoll.part3;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class HashTableTest {

    public static void main(String[] args) {
        warmUp();         // Warm up JVM for accurate timing results
        testHashTable();  // Run tests on different configurations
    }

    /**
     * Warms up JVM by performing dummy operations on a temporary hash table.
     */
    private static void warmUp() {
        System.out.println("Warming up JVM...");
        
        HashTable<Integer, String> warmupTable = new HashTable<>();
        
        for (int i = 0; i < 10000; i++) {
            warmupTable.put(i, "Warmup" + i);
            warmupTable.get(i);
            warmupTable.delete(i);
        }
        
        System.out.println("Warm-up complete.\n");
    }

    /**
     * Tests different combinations of hashing techniques and collision resolution strategies.
     */
        public static void testHashTable() {
        int[] hashFunctions = {1, 2, 3};         // Division, Multiplication, Universal Hashing
        int[] collisionResolutions = {1, 2, 3}; // Linear Probing, Quadratic Probing, Double Hashing
        int numKeys = 1000000; // Increase to match sample output
    
        for (int hashFunction : hashFunctions) {
            for (int collisionResolution : collisionResolutions) {
                System.out.println("Testing with " + getHashFunctionName(hashFunction) + 
                                   " and " + getCollisionResolutionName(collisionResolution));
    
                HashTable<Integer, String> hashTable = new HashTable<>(16, hashFunction, collisionResolution);
    
                Integer[] keysToInsert = generateRandomKeys(numKeys);
    
                // Insert keys and measure time
                long startTime = System.nanoTime();
                for (Integer key : keysToInsert) {
                    hashTable.put(key, "Value" + key);
                }
                long insertionTime = System.nanoTime() - startTime;
    
                // Search existing keys and measure time
                int foundExistingKeys = 0;
                startTime = System.nanoTime();
                for (Integer key : keysToInsert) {
                    if (hashTable.get(key) != null) {
                        foundExistingKeys++;
                    }
                }
                long searchTimeExistingKeys = System.nanoTime() - startTime;
    
                // Search non-existing keys and measure time
                Integer[] nonExistingKeys = generateNonExistingKeys(numKeys, keysToInsert);
                int confirmedNonExistingKeys = 0;
                startTime = System.nanoTime();
                for (Integer key : nonExistingKeys) {
                    if (hashTable.get(key) == null) {
                        confirmedNonExistingKeys++;
                    }
                }
                long searchTimeNonExistingKeys = System.nanoTime() - startTime;
    
                // Print results in the expected format
                System.out.println("Insertion time: " + insertionTime / 1000000 + " ms");
                System.out.println("Existing key search time: " + searchTimeExistingKeys / 1000000 + " ms");
                System.out.println("Non-existing key search time: " + searchTimeNonExistingKeys / 1000000 + " ms");
                System.out.println("Number of collisions: " + hashTable.getCollisions());
                System.out.println("Average probe length: " + hashTable.getAverageProbeLength());
                System.out.println("Load factor: " + hashTable.getLoadFactor());
                System.out.println("Found " + foundExistingKeys + " existing keys out of " + numKeys + " searches");
                System.out.println("Confirmed " + confirmedNonExistingKeys + " non-existing keys out of " + numKeys + " searches");
                System.out.println();
            }
        }
        
        System.out.println("\nTesting complete.");
    }

    /**
     * Generates an array of random integer keys.
     * @param count The number of keys to generate.
     * @return An array of random integer keys.
     */
    private static Integer[] generateRandomKeys(int count) {
        Integer[] keys = new Integer[count];
        Random random = new Random(42); // Fixed seed for reproducibility
        
        for (int i = 0; i < count; i++) {
            keys[i] = random.nextInt(1000000); // Generate random integers up to 1,000,000
        }
        
        return keys;
    }

    /**
     * Generates an array of integer keys that do not exist in the given set of existing keys.
     * @param count The number of non-existing keys to generate.
     * @param existingKeys The array of existing keys.
     * @return An array of non-existing integer keys.
     */
    private static Integer[] generateNonExistingKeys(int count, Integer[] existingKeys) {
        Integer[] nonExistingKeys = new Integer[count];
        Random random = new Random(24); // Different seed from generateRandomKeys
        
        // Put existing keys in a set for O(1) lookups
        Set<Integer> existingKeySet = new HashSet<>();
        for (Integer key : existingKeys) {
            existingKeySet.add(key);
        }
        
        int i = 0;
        while (i < count) {
            int candidate = random.nextInt(2000000); // Larger range to find non-existing keys
            
            // Only add if not in the existing keys set
            if (!existingKeySet.contains(candidate)) {
                nonExistingKeys[i] = candidate;
                i++;
            }
        }
        
        return nonExistingKeys;
    }

    /**
     * Converts a hash function constant into a readable name.
     * @param hashFunction The constant representing the hash function.
     * @return The name of the hash function.
     */
    private static String getHashFunctionName(int hashFunction) {
        switch (hashFunction) {
            case 1:
                return "DIVISION_HASH";
            case 2:
                return "MULTIPLICATION_HASH";
            case 3:
                return "UNIVERSAL_HASH";
            default:
                return "UNKNOWN_HASH_FUNCTION";
        }
    }

    /**
     * Converts a collision resolution constant into a readable name.
     * @param collisionResolution The constant representing the collision resolution strategy.
     * @return The name of the collision resolution strategy.
     */
    private static String getCollisionResolutionName(int collisionResolution) {
        switch (collisionResolution) {
            case 1:
                return "LINEAR_PROBING";
            case 2:
                return "QUADRATIC_PROBING";
            case 3:
                return "DOUBLE_HASHING";
            default:
                return "UNKNOWN_COLLISION_RESOLUTION";
        }
    }
}
