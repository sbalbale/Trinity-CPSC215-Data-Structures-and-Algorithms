package edu.trincoll.part2;

/**
 * DQStack - A Stack implementation using a DLDQueue.
 * This class adapts a double-ended queue (deque) to function as a LIFO stack.
 * 
 * @param <E> The type of elements stored in this stack
 */
public class DQStack<E> implements Stack<E> {
   // Data attribute - the underlying deque used to store stack elements
   private DLDQueue<E> data;

   /**
    * Constructs an empty stack.
    */
   public DQStack() {
      data = new DLDQueue<E>();
   }

   /**
    * Pushes an element onto the top of the stack.
    * For a stack implemented with a deque, we insert at the beginning.
    * 
    * @param obj The element to push onto the stack
    */
   @Override
   public void push(E obj) {
      data.insertFirst(obj);
   }

   /**
    * Removes and returns the element at the top of the stack.
    * For a stack implemented with a deque, we remove from the beginning.
    * 
    * @return The top element of the stack, or null if empty
    */
   @Override
   public E pop() {
      return data.removeFirst();
   }

   /**
    * Returns the number of elements in the stack.
    * 
    * @return The size of the stack
    */
   @Override
   public int size() {
      return data.size();
   }

   /**
    * Returns a string representation of the stack.
    * 
    * @return A string representation of the underlying deque
    */
   @Override
   public String toString() {
      return data.toString();
   }
}