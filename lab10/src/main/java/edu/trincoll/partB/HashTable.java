package edu.trincoll.partB;

class HashTable<K, V> {
    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private static final int TABLE_SIZE = 500000;
    private Entry<K, V>[] table;

    public HashTable() {
        table = new Entry[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = null;
        }
    }

    private int hashFunction(K key) {
        return key.hashCode() % TABLE_SIZE;
    }

    public void put(K key, V value) {
        int index = hashFunction(key);
        Entry<K, V> newNode = new Entry<>(key, value);
        if (table[index] == null) {
            table[index] = newNode;
        } else {
            Entry<K, V> current = table[index];
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public V get(K key) {
        int index = hashFunction(key);
        Entry<K, V> current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public void delete(K key) {
        int index = hashFunction(key);
        Entry<K, V> current = table[index];
        Entry<K, V> prev = null;
        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }
}
