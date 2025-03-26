package edu.trincoll.part4;

// Main class for testing
public class SortTest {
    public static void main(String[] args) {
        // Create a linked list and add elements
        LinkedList<String> list = new LinkedList<>();
        list.add("Hannah");
        list.add("Adam");
        list.add("Zeek");
        list.add("Mike");
        list.add("Emily");
        list.add("Chloe");
        list.add("Tiffany");
        list.add("Nikita");

        // Display original list
        System.out.println("Original List:");
        list.display();
        System.out.println();

        // Test Bubble Sort
        System.out.println("Bubble Sort:");
        list.bubbleSort();
        list.display();
        System.out.println();

        // Test Selection Sort
        System.out.println("Selection Sort:");
        list.selectionSort();
        list.display();
        System.out.println();

        // Test Insertion Sort
        System.out.println("Insertion Sort:");
        list.insertionSort();
        list.display();
        System.out.println();

        // Perform successful linear search
        String key = "Chloe";
        System.out.println("Linear search for key " + key + ": " + list.linearSearch(key));
        // Perform unsuccessful linear search
        key = "Nil";
        System.out.println("Linear search for key " + key + ": " + list.linearSearch(key));
        System.out.println();
        
        // Perform successful binary search
        key = "Hannah";
        System.out.println("Binary search for key " + key + ": " + list.binarySearch(key));
        // Perform unsuccessful binary search
        key = "Biden";
        System.out.println("Binary search for key " + key + ": " + list.binarySearch(key));
    
    }
}