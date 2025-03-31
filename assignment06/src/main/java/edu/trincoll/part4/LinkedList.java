package edu.trincoll.part4;

/**
 * LinkedList class
 * A generic implementation of a singly linked list with sorting and searching
 * functionalities.
 * Note: You cannot use java.util package.
 *
 * @param <E> the type of elements in this list
 */
class LinkedList<E> {
    // Node representing the head of the list
    private Node<E> head;
    // Size of the linked list
    private int size;

    /**
     * Constructor to initialize an empty linked list.
     */
    public LinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Adds an element to the end of the linked list.
     *
     * @param data the element to be added
     */
    public void add(E data) {
        Node<E> newNode = new Node<>(data); // Create a new node with the given data
        if (head == null) {
            head = newNode; // If the list is empty, set the new node as the head
        } else {
            Node<E> current = head;
            // Traverse to the end of the list
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode; // Append the new node at the end
        }
        size++; // Increment the size of the list
    }

    /**
     * Displays the elements of the linked list.
     */
    public void display() {
        Node<E> current = head; // Start from the head
        while (current != null) {
            System.out.print(current.data + " "); // Print the data of the current node
            current = current.next; // Move to the next node
        }
        System.out.println(); // Print a newline at the end
    }

    /**
     * Sorts the linked list using the Bubble Sort algorithm.
     */
    public void bubbleSort() {
        if (head == null || head.next == null) {
            return; // List is empty or has only one element
        }
        boolean swapped;
        do {
            swapped = false;
            Node<E> current = head;
            while (current.next != null) {
                // Compare adjacent nodes and swap if needed
                if (((Comparable<E>) current.data).compareTo(current.next.data) > 0) {
                    E temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true; // Mark that a swap occurred
                }
                current = current.next; // Move to the next node
            }
        } while (swapped); // Repeat until no swaps are needed
    }

    /**
     * Sorts the linked list using the Selection Sort algorithm.
     */
    public void selectionSort() {
        if (head == null || head.next == null) {
            return; // List is empty or has only one element
        }
        Node<E> current = head;
        while (current != null) {
            Node<E> minNode = current; // Assume the current node is the minimum
            Node<E> nextNode = current.next;
            while (nextNode != null) {
                // Find the node with the smallest value
                if (((Comparable<E>) nextNode.data).compareTo(minNode.data) < 0) {
                    minNode = nextNode;
                }
                nextNode = nextNode.next;
            }
            // Swap the data of the current node and the minimum node
            if (minNode != current) {
                E temp = current.data;
                current.data = minNode.data;
                minNode.data = temp;
            }
            current = current.next; // Move to the next node
        }
    }

    /**
     * Sorts the linked list using the Insertion Sort algorithm.
     */
    public void insertionSort() {
        if (head == null || head.next == null) {
            return; // List is empty or has only one element
        }
        Node<E> sortedList = null; // Initialize a new sorted list
        Node<E> current = head;
        while (current != null) {
            Node<E> next = current.next; // Store the next node
            sortedList = insert(sortedList, current); // Insert the current node into the sorted list
            current.next = null; // Disconnect the current node from the original list
            current = next; // Move to the next node
        }
        head = sortedList; // Update the head to point to the new sorted list
    }

    /**
     * Helper method to insert a node into a sorted linked list.
     *
     * @param sorted  the head of the sorted list
     * @param newNode the node to be inserted
     * @return the head of the updated sorted list
     */
    private Node<E> insert(Node<E> sorted, Node<E> newNode) {
        if (sorted == null || ((Comparable<E>) newNode.data).compareTo(sorted.data) < 0) {
            newNode.next = sorted; // Insert at the beginning
            return newNode;
        }
        Node<E> current = sorted;
        // Traverse to find the correct position for the new node
        while (current.next != null && ((Comparable<E>) newNode.data).compareTo(current.next.data) > 0) {
            current = current.next;
        }
        newNode.next = current.next; // Insert the new node
        current.next = newNode;
        return sorted;
    }

    /**
     * Performs a linear search for a key in the linked list.
     *
     * @param key the element to search for
     * @return true if the key is found, false otherwise
     */
    public boolean linearSearch(E key) {
        Node<E> current = head; // Start from the head
        while (current != null) {
            if (current.data.equals(key)) {
                return true; // Key found
            }
            current = current.next; // Move to the next node
        }
        return false; // Key not found
    }

    /**
     * Performs a binary search for a key in the linked list.
     * Note: The list must be sorted for binary search to work correctly.
     *
     * @param key the element to search for
     * @return true if the key is found, false otherwise
     */
    public boolean binarySearch(E key) {
        if (head == null) {
            return false; // List is empty
        }
        int left = 0;
        int right = size - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate the middle index
            Node<E> midNode = getNode(mid); // Get the node at the middle index
            if (midNode.data.equals(key)) {
                return true; // Key found
            } else if (((Comparable<E>) midNode.data).compareTo(key) < 0) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }
        return false; // Key not found
    }

    /**
     * Retrieves the node at the specified index.
     *
     * @param index the index of the node to retrieve
     * @return the node at the specified index, or null if the index is out of
     *         bounds
     */
    private Node<E> getNode(int index) {
        if (index < 0 || index >= size) {
            return null; // Index out of bounds
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next; // Traverse to the specified index
        }
        return current; // Return the node at the specified index
    }

    /**
     * Retrieves the index of the specified node.
     *
     * @param node the node to find the index of
     * @return the index of the node, or -1 if the node is not found
     */
    private int indexOf(Node<E> node) {
        if (node == null) {
            return -1; // Node is null
        }
        Node<E> current = head;
        int index = 0;
        while (current != null) {
            if (current == node) {
                return index; // Node found
            }
            current = current.next;
            index++;
        }
        return -1; // Node not found
    }

}
