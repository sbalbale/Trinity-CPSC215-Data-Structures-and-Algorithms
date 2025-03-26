package edu.trincoll.part2;

public class HashTable<K, V> {
    private int size;
    private int capacity;
    private Entry<K, V>[] table;
    // Other attributes (if needed)

    public HashTable(int capacity) {
        // To do: Complete this
    }

    // Hash function 1
    private int hashFunction1(K key) { // h1(x) = x % capacity 
        return Math.abs((key.hashCode()) % capacity);
    }

    // Hash function 2
    private int hashFunction2(K key) { // h2(key)= 7 − (abs(h1(key)) % 7) 
        // Using a prime number less than the table size for step size
        int prime = 7;  // Use this prime number
        // To do: Complete this
    }

    // Double hashing to resolve collisions
    private int doubleHash(K key, int i) {
        // To do: Complete this
    }

    // Insert a key-value pair into the hash table
    public void put(K key, V value) {
        // To do: Complete this
    }

    // Get the value associated with a key from the hash table
    public V get(K key) {
        // To do: Complete this
    }

    // Remove a key-value pair from the hash table
    public void remove(K key) {
        // To do: Complete this
    }

    // Print the contents of the hash table
    public void print() {
        // To do: Complete this
    }

    // You may use additional methods to implement the functionality above
}


