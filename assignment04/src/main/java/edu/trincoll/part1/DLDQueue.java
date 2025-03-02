package edu.trincoll.part1;

public class DLDQueue<E> implements DQueue<E> {
  // Define the Node inner class for our doubly linked list
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

  public DLDQueue() {
    head = null;
    tail = null;
    size = 0;
  }

  public void insertFirst(E obj) {
    Node newNode = new Node(obj);

    if (isEmpty()) {
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

  public void insertLast(E obj) {
    Node newNode = new Node(obj);

    if (isEmpty()) {
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

  public E removeFirst() {
    if (isEmpty()) {
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

  public E removeLast() {
    if (isEmpty()) {
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

  public int size() {
    return size;
  }

  private boolean isEmpty() {
    return size == 0;
  }

  @Override
  public void truncate_first(int num) {
    // Don't try to remove more elements than exist
    int elementsToRemove = Math.min(num, size);

    for (int i = 0; i < elementsToRemove; i++) {
      removeFirst();
    }
  }

  @Override
  public void truncate_last(int num) {
    // Don't try to remove more elements than exist
    int elementsToRemove = Math.min(num, size);

    for (int i = 0; i < elementsToRemove; i++) {
      removeLast();
    }
  }

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