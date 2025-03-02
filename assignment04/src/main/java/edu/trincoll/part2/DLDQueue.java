package edu.trincoll.part2;

/**
 * DLDQueue - Implementation of a Double-Linked Deque using a doubly linked
 * list.
 * This class supports operations at both ends of the deque.
 * 
 * @param <E> The type of elements stored in this deque
 */
public class DLDQueue<E> implements DQueue<E> {
  /**
   * Adds an element to the end of the deque.
   * 
   * @param obj The element to add
   */
  @Override
  public void enqueue(E obj) {
    insertLast(obj);
  }

  /**
   * Removes and returns the element from the beginning of the deque.
   * 
   * @return The first element, or null if the deque is empty
   */
  @Override
  public E dequeue() {
    return removeFirst();
  }
  // Node inner class for the doubly linked list
  private class Node {
    E data;
    Node next;
    Node prev;

    public Node(E obj) {
      this.data = obj;
      this.next = null;
      this.prev = null;
    }
  }

  // Instance variables
  private Node head; // Reference to the first node
  private Node tail; // Reference to the last node
  private int size; // Number of elements in the queue

  /**
   * Constructs an empty deque.
   */
  public DLDQueue() {
    head = null;
    tail = null;
    size = 0;
  }

  /**
   * Inserts an object at the beginning of the deque.
   * 
   * @param obj The element to add
   */
  public void insertFirst(E obj) {
    Node newNode = new Node(obj);

    if (size == 0) {
      // If the queue is empty, the new node is both head and tail
      head = newNode;
      tail = newNode;
    } else {
      // Link the new node to the current head
      newNode.next = head;
      head.prev = newNode;
      head = newNode;
    }
    size++;
  }

  /**
   * Inserts an object at the end of the deque.
   * 
   * @param obj The element to add
   */
  public void insertLast(E obj) {
    Node newNode = new Node(obj);

    if (size == 0) {
      // If the queue is empty, the new node is both head and tail
      head = newNode;
      tail = newNode;
    } else {
      // Link the new node to the current tail
      newNode.prev = tail;
      tail.next = newNode;
      tail = newNode;
    }
    size++;
  }

  /**
   * Extracts and removes an object from the beginning of the deque.
   * 
   * @return The first element, or null if the deque is empty
   */
  public E removeFirst() {
    if (size == 0) {
      return null;
    }

    E removedData = head.data;

    if (head == tail) {
      // Only one node in list
      head = null;
      tail = null;
    } else {
      // More than one node, update head
      head = head.next;
      head.prev = null;
    }

    size--;
    return removedData;
  }

  /**
   * Extracts and removes an object from the end of the deque.
   * 
   * @return The last element, or null if the deque is empty
   */
  public E removeLast() {
    if (size == 0) {
      return null;
    }

    E removedData = tail.data;

    if (head == tail) {
      // Only one node in list
      head = null;
      tail = null;
    } else {
      // More than one node, update tail
      tail = tail.prev;
      tail.next = null;
    }

    size--;
    return removedData;
  }

  /**
   * Returns the number of elements in the deque.
   * 
   * @return The size of the deque
   */
  public int size() {
    return size;
  }

  /**
   * Removes a specified number of elements from the beginning of the deque.
   * 
   * @param num The number of elements to remove
   */
  @Override
  public void truncate_first(int num) {
    // Don't try to remove more elements than exist
    int elementsToRemove = Math.min(num, size);

    for (int i = 0; i < elementsToRemove; i++) {
      removeFirst();
    }
  }

  /**
   * Removes a specified number of elements from the end of the deque.
   * 
   * @param num The number of elements to remove
   */
  @Override
  public void truncate_last(int num) {
    // Don't try to remove more elements than exist
    int elementsToRemove = Math.min(num, size);

    for (int i = 0; i < elementsToRemove; i++) {
      removeLast();
    }
  }

  /**
   * Returns a string representation of the deque.
   * 
   * @return A string in the format "head [ elem1-elem2-... ] tail"
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("head [ ");

    Node current = head;
    while (current != null) {
      sb.append(current.data);

      if (current.next != null) {
        sb.append("-");
      }

      current = current.next;
    }

    sb.append(" ] tail");
    return sb.toString();
  }
}