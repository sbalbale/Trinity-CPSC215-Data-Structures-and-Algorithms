package edu.trincoll.part2;

/**
 * DQQueue - A Queue implementation using a DLDQueue.
 * This class adapts a double-ended queue (deque) to function as a FIFO queue.
 * 
 * @param <E> The type of elements stored in this queue
 */
public class DQQueue<E> implements Queue<E> {
  // Data attribute - the underlying deque used to store queue elements
  private DLDQueue<E> data;

  /**
   * Constructs an empty queue.
   */
  public DQQueue() {
    data = new DLDQueue<E>();
  }

  /**
   * Adds an element to the end of the queue.
   * For a queue implemented with a deque, we insert at the beginning.
   * 
   * @param obj The element to add
   */
  public void enqueue(E obj) {
    data.insertFirst(obj);
  }

  /**
   * Removes and returns the front element from the queue.
   * For a queue implemented with a deque, we remove from the end.
   * 
   * @return The front element of the queue, or null if empty
   */
  public E dequeue() {
    return data.removeLast();
  }

  /**
   * Returns the number of elements in the queue.
   * 
   * @return The size of the queue
   */
  public int size() {
    return data.size();
  }

  /**
   * Returns a string representation of the queue.
   * 
   * @return A string representation of the underlying deque
   */
  public String toString() {
    return data.toString();
  }
}