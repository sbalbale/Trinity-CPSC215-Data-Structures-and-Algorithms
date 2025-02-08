package edu.trincoll.part4;

/**
 * Test class for the LinkedList implementation.
 * Demonstrates the functionality of the LinkedList class with both Integer and String types.
 * Tests various operations including insertion, display, duplicate removal, and sorted insertion.
 */
public class LinkedListTest {
    
    /**
     * Main method to run tests on the LinkedList implementation.
     * Creates multiple test cases to demonstrate:
     * - Basic insertion operations (beginning and end)
     * - String and Integer type compatibility
     * - Duplicate removal functionality
     * - Sorted insertion capability
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Test Case 1: Basic Integer List Operations
        System.out.println("Creating a new List - 1");
        LinkedList<Integer> integerList = new LinkedList<>();
        System.out.println("Inserting 5 at beginning");
        integerList.insertAtBeginning(5);
        System.out.println("Inserting 30 at end");
        integerList.insertAtEnd(30);
        System.out.println("Inserting 15 at end");
        integerList.insertAtEnd(15);
        System.out.println("Printing the Linked List - 1:");
        integerList.display();
        System.out.println();

        // Test Case 2: String List Operations
        System.out.println("Creating another String List - 2");
        LinkedList<String> stringList = new LinkedList<>();
        stringList.insertAtBeginning("Hello");
        System.out.println("Inserting Hello at beginning");
        stringList.insertAtEnd("World");
        System.out.println("Inserting World at end");
        stringList.insertAtBeginning("Morning");
        System.out.println("Inserting Morning at beginning");
        System.out.println("Printing the String Linked List - 2:");
        stringList.display();
        System.out.println();

        // Test Case 3: Remove Duplicates
        System.out.println("Testing remove duplicates");
        System.out.println("Creating another Integer List - 3");
        LinkedList<Integer> integerList_1 = new LinkedList<>();
        integerList_1.insertAtEnd(5);
        System.out.println("Inserting 5 at beginning");
        integerList_1.insertAtEnd(10);
        System.out.println("Inserting 10 at end");
        integerList_1.insertAtEnd(50);
        System.out.println("Inserting 50 at end");
        integerList_1.insertAtEnd(15);
        System.out.println("Inserting 15 at end");
        integerList_1.insertAtEnd(10);
        System.out.println("Inserting 10 at end");
        integerList_1.insertAtEnd(5);
        System.out.println("Inserting 5 at end");
        System.out.println("Original Integer Linked List:");
        integerList_1.display();
        integerList_1.removeDuplicates();
        System.out.println("After removing duplicates:");
        integerList_1.display();
        System.out.println();

        // Test Case 4: Sorted Insertion
        System.out.println("Testing Insert Sorted");
        System.out.println("Creating another Integer List - 4");
        LinkedList<Integer> integerList_2 = new LinkedList<>();
        integerList_2.insertSorted(10);
        System.out.println("Inserting 10");
        integerList_2.insertSorted(5);
        System.out.println("Inserting 5");
        integerList_2.insertSorted(20);
        System.out.println("Inserting 20");
        integerList_2.insertSorted(15);
        System.out.println("Inserting 15");
        System.out.println("Integer Linked List with elements added using insertSorted:");
        integerList_2.display();
        System.out.println();
    }
}