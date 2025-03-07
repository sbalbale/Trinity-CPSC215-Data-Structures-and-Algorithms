package edu.trincoll;

/**
 * The DList class represents a doubly linked list implementation.
 * It provides methods to insert, remove, display, and manipulate elements in
 * the list.
 * The list is initialized with head and tail sentinel nodes to simplify edge
 * case handling.
 * 
 * Methods:
 * - DList(): Constructs an empty doubly linked list with head and tail sentinel
 * nodes.
 * - void insert(Job it): Inserts a new job at the beginning of the list.
 * - void remove(Job it): Removes the specified job from the list.
 * - void display(): Displays the elements of the list from head to tail.
 * - void skip_display(int n): Displays every nth element in the list starting
 * from the head.
 * - void reverse(): Reverses the list and prints the elements from tail to
 * head.
 * - void remove_duplicates(): Removes duplicate elements from the list based on
 * job ID.
 */
public class DList implements List {

    /**
     * The head and tail sentinel nodes of the doubly linked list.
     */
    DLink head;
    DLink tail;

    /**
     * Constructs an empty doubly linked list.
     * Initializes the list with a head and tail sentinel nodes.
     * The head's next pointer is set to the tail, and the tail's previous pointer
     * is set to the head.
     */
    public DList() {
        head = new DLink(null);
        tail = new DLink(null);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * Inserts a new job at the end of the doubly linked list.
     *
     * @param it the job to be inserted into the list
     */
    public void insert(Job it) {
        DLink temp = new DLink(it);
        temp.next = tail;
        temp.prev = tail.prev;
        tail.prev.next = temp;
        tail.prev = temp;
    }

    /**
     * Removes the specified job from the doubly linked list.
     *
     * @param it the job to be removed from the list
     */
    public void remove(Job it) {
        DLink temp = head.next;
        while (temp != tail) {
            if (temp.data.getJobId() == it.getJobId()) {
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            }
            temp = temp.next;
        }

    }

    /**
     * Displays the elements of the doubly linked list from head to tail.
     * Iterates through the list starting from the node after the head and
     * prints the data of each node until it reaches the tail.
     */
    public void display() {
        DLink temp = head.next;
        while (temp != tail) {
            System.out.println(temp.data.toString());
            temp = temp.next;
        }
    }

    /**
     * Displays every nth element in the doubly linked list starting from the head.
     * 
     * @param n the number of elements to skip before starting to display elements.
     *          For example, if n is 2, it will skip the first 2 elements and then
     *          display every element after that.
     */
    public void skip_display(int n) {
        DLink temp = head.next;
        for (int i = 0; i < n; i++) {
            temp = temp.next;
        }
        while (temp != tail) {
            System.out.println(temp.data.toString());
            temp = temp.next;
        }
    }

    /**
     * Reverses the doubly linked list by swapping the next and prev pointers
     * of all nodes while preserving the sentinel structure.
     */
    public void reverse() {

        DLink current = head.next;

        while (current != tail) {

            DLink nextNode = current.next;

            current.prev.next = current.next;
            current.next.prev = current.prev;

            current.next = head.next;
            current.prev = head;
            head.next.prev = current;
            head.next = current;

            current = nextNode;
        }
    }

    /**
     * Removes duplicate elements from the doubly linked list.
     * This method iterates through the list and removes any nodes
     * that have the same job ID as a previous node.
     * 
     * The method uses two nested while loops to compare each node
     * with every other node in the list. If a duplicate is found,
     * the duplicate node is removed by adjusting the pointers of
     * the previous and next nodes.
     */
    public void remove_duplicates() {
        DLink temp = head.next;
        while (temp != tail) {
            DLink temp2 = temp.next;
            while (temp2 != tail) {
                if (temp.data.getJobId() == temp2.data.getJobId()) {
                    temp2.prev.next = temp2.next;
                    temp2.next.prev = temp2.prev;
                }
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
    }

    /**
     * Checks if the doubly linked list is empty.
     * 
     * @return
     */
    public boolean isEmpty() {
        return head.next == tail;
    }

    /**
     * Returns the head sentinel node of the doubly linked list.
     * 
     * @return the head sentinel node
     */
    public DLink getHead() {
        return head;
    }

    /**
     * Returns the tail sentinel node of the doubly linked list.
     * 
     * @return the tail sentinel node
     */

    public DLink getTail() {
        return tail;
    }

}
