package edu.trincoll.part2;
// Entry class to hold key-value pairs
public class Entry<K, V> {
        K key;
        V value;
        boolean deleted;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.deleted = false;
        }
    }