package edu.trincoll.part2;

public class Test {
    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>(10);
        hashTable.put("John", 25);
        hashTable.put("Alice", 30);
        hashTable.put("Alicia", 30);
        hashTable.put("Bob", 35);
        hashTable.put("David", 40);
        hashTable.put("Davis", 40); // Add more entries to simulate multiple collisions

        System.out.println("Value for key 'John': " + hashTable.get("John"));
        System.out.println("Value for key 'Alice': " + hashTable.get("Alice"));
        System.out.println("Value for key 'Alice': " + hashTable.get("Alicia"));
        System.out.println("Value for key 'Bob': " + hashTable.get("Bob"));
        System.out.println("Value for key 'David': " + hashTable.get("David"));
        System.out.println("Value for key 'David': " + hashTable.get("Davis"));

        hashTable.remove("Alice");
        System.out.println("Value for key 'Alice' after removal: " + hashTable.get("Alice"));

        hashTable.print();
    }
}