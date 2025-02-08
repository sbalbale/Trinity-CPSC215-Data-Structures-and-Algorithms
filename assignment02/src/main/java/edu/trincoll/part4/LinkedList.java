package edu.trincoll.part4;

/**
 * A generic singly linked list implementation that maintains elements in sorted order.
 * The list can store any type that implements the Comparable interface.
 *
 * @param <T> the type of elements in this list, must implement Comparable
 */
public class LinkedList<T extends Comparable<T>> {
    private Node<T> head;

    /**
     * Constructs an empty linked list.
     * Initializes the head pointer to null.
     */
    public LinkedList() {
        this.head = null;
    }

    /**
     * Inserts a new element at the beginning of the linked list.
     * Creates a new node and updates the head pointer accordingly.
     * Time complexity: O(1)
     *
     * @param data the element to be inserted at the beginning
     */
    public void insertAtBeginning(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
    }

    /**
     * Inserts a new element at the end of the linked list.
     * Traverses to the end of the list and adds the new node.
     * Time complexity: O(n) where n is the number of elements
     *
     * @param data the element to be inserted at the end
     */
    public void insertAtEnd(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    /**
     * Displays all elements in the linked list.
     * Elements are printed in order, separated by spaces, followed by a newline.
     * Time complexity: O(n) where n is the number of elements
     */
    public void display() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    /**
     * Inserts a new element into the linked list while maintaining sorted order.
     * Uses the natural ordering of elements defined by their compareTo method.
     * If the list is empty or the new element is smaller than the head, inserts at beginning.
     * Otherwise, finds the appropriate position to maintain sorted order.
     * Time complexity: O(n) where n is the number of elements
     *
     * @param data the element to be inserted in sorted position
     */
    public void insertSorted(T data) {
        Node<T> newNode = new Node<>(data);

        // Case 1: Empty list or insert at beginning
        if (head == null || head.data.compareTo(data) > 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        // Case 2: Insert in middle or end
        Node<T> current = head;
        while (current.next != null && current.next.data.compareTo(data) < 0) {
            current = current.next;
        }

        // Insert the new node
        newNode.next = current.next;
        current.next = newNode;
    }

    /**
     * Removes all duplicate elements from the linked list.
     * Preserves the first occurrence of each element and removes subsequent duplicates.
     * Uses nested loops to compare each element with all subsequent elements.
     * Updates next references to skip duplicate nodes.
     * Time complexity: O(n²) where n is the number of elements
     */
    public void removeDuplicates() {
        // Empty list or single element - no duplicates to remove
        if (head == null || head.next == null) {
            return;
        }

        // Outer loop - iterate through each node
        Node<T> current = head;
        while (current != null) {
            // Inner loop - check all subsequent nodes for duplicates
            Node<T> runner = current;
            while (runner.next != null) {
                // If duplicate found, skip the duplicate node
                if (runner.next.data.equals(current.data)) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }
}