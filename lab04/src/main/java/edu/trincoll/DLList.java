package edu.trincoll;
/**
 * Implementation of the List ADT using a doubly linked list.
 * 
 * @param <E> The type of elements in this list.
 */
class DLList<E> implements List<E> {
    private DLink<E> head;
    private DLink<E> tail;
    protected DLink<E> curr;
    private int cnt;

    /** Default constructor. Initializes an empty list. */
    DLList() {
        head = new DLink<>(null, null, null);
        tail = new DLink<>(null, head, null);
        head.next = tail;
        curr = head;
        cnt = 0;
    }

    /**
     * Clears the entire list, removing all elements and resetting to initial state.
     * After this operation, the list will be empty with count set to 0.
     */
    @Override
    public void clear() {
        head.next = tail;
        tail.prev = head;
        curr = head;
        cnt = 0;
    }

    /**
     * Inserts a new element after the current position in the list.
     * The new element becomes the current element's next node.
     * 
     * @param it The element to be inserted
     */
    @Override
    public void insert(E it) {
        DLink<E> newNode = new DLink<>(it, curr, curr.next);
        curr.next.prev = newNode;
        curr.next = newNode;
        if (curr == tail.prev) {
            tail.prev = newNode;
        }
        cnt++;
    }

    /**
     * Adds a new element to the end of the list.
     * 
     * @param it The element to be appended
     */
    @Override
    public void append(E it) {
        DLink<E> newNode = new DLink<>(it, tail.prev, tail);
        tail.prev.next = newNode;
        tail.prev = newNode;
        cnt++;
    }

    /**
     * Removes and returns the element following the current position.
     * 
     * @return The removed element, or null if no element exists after current position
     */
    @Override
    public E remove() {
        if (curr.next == tail) return null; // No element to remove

        E it = curr.next.element;
        curr.next = curr.next.next;
        curr.next.prev = curr;
        cnt--;
        return it;
    }

    /**
    * Moves the current position to the start of the list (before the first element).
    */
    @Override
    public void moveToStart() {
        curr = head;
    }

    /**
     * Moves the current position to the end of the list (after the last element).
     */
    @Override
    public void moveToEnd() {
        curr = tail.prev;
    }

    /**
     * Moves the current position one step to the left.
     * No change if already at the beginning.
     */
    @Override
    public void prev() {
        if (curr != head) {
            curr = curr.prev;
        }
    }

    /**
     * Moves the current position one step to the right.
     * No change if already at the end.
     */
    @Override
    public void next() {
        if (curr.next != tail) {
            curr = curr.next;
        }
    }

    /**
     * Returns the number of elements in the list.
     * 
     * @return The current length (size) of the list
     */
    @Override
    public int length() {
        return cnt;
    }

    /**
     * Returns the position of the current element in the list.
     * 
     * @return The current position in the list
     */
    @Override
    public int currPos() {
        DLink<E> temp = head;
        int i;
        for (i = 0; curr != temp; i++) {
            temp = temp.next;
        }
        return i;
    }

    /**
     * Moves the current position to the specified position in the list.
     * 
     * @param pos The position to move to
     * @throws IndexOutOfBoundsException if the position is invalid
     */
    @Override
    public void moveToPos(int pos) {
        if (pos < 0 || pos >= cnt) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        curr = head;
        for (int i = 0; i < pos; i++) {
            curr = curr.next;
        }
    }

    /**
     * Returns the value of the element following the current position.
     * 
     * @return The element after current position, or null if at the end
     */
    @Override
    public E getValue() {
        return (curr.next != tail) ? curr.next.element : null;
    }

    /**
     * Removes the last element from the list.
     * If the list is empty, no action is taken.
     */
    public void removeLast() {
        if (tail.prev != head) {
            tail.prev = tail.prev.prev;
            tail.prev.next = tail;
            cnt--;
        }
    }

    /**
     * Removes the first element from the list.
     * If the list is empty, no action is taken.
     */
    public void removeFirst() {
        if (head.next != tail) {
            head.next = head.next.next;
            head.next.prev = head;
            cnt--;
        }
    }
    
    /**
     * Finds and returns the middle element of the list using the slow/fast pointer technique.
     * 
     * @return The middle element of the list
     */
    public E findMiddle() {
        DLink<E> slow = head;
        DLink<E> fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.element;
    }

    /**
     * Inserts an element at the specified position in the list.
     * 
     * @param pos The position at which to insert the element
     * @param data The element to insert
     * @throws IndexOutOfBoundsException if the position is invalid
     */
    public void insertAtPosition(int pos, E data) {
        if (pos < 0 || pos > cnt) {
            throw new IndexOutOfBoundsException("Invalid position");
        }
        moveToPos(pos);
        insert(data);
    }
    
    /**
     * Displays all elements at even positions in the list.
     * Position counting starts at 0.
     */
    public void displayEvenElements(){
        moveToStart();
        for (int i = 0; i < cnt; i++) {
            if (i % 2 == 0) {
                System.out.print(getValue() + " ");
            }
            next();
        }
    }

    /**
     * Removes all duplicate elements from the list.
     * Compares elements using reference equality.
     */
    public void removeDuplicates() {
        // Empty list or single element - no duplicates to remove
        if (cnt <= 1) {
            return;
        }

        // Outer loop - iterate through each node
        DLink<E> current = head.next;
        while (current != tail) {
            // Inner loop - check all subsequent nodes for duplicates
            DLink<E> runner = current;
            while (runner.next != tail) {
                if (runner.next.element.equals(current.element)) {
                    runner.next.next.prev = runner;
                    runner.next = runner.next.next;
                    cnt--;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }


    /**
     * Sorts the list using bubble sort algorithm.
     * Note: This implementation assumes the elements are Integers.
     */
    public void bubbleSort(){
        if (cnt == 0 || cnt == 1) return;
        for (int i = 0; i < cnt - 1; i++) {
            moveToStart();
            for (int j = 0; j < cnt - i - 1; j++) {
                if ((Integer) getValue() > (Integer) curr.next.element) {
                    E temp = curr.next.element;
                    curr.next.element = curr.next.next.element;
                    curr.next.next.element = temp;
                }
                next();
            }
        }
    }

    /**
     * Reverses the order of elements in the list.
     * This operation modifies the list in-place.
     */
    public void reverse(){
        DLink<E> temp = head;
        head = tail;
        tail = temp;
        moveToStart();
        for (int i = 0; i < cnt; i++) {
            temp = curr.next;
            curr.next = curr.prev;
            curr.prev = temp;
            next();
        }
    }

}
