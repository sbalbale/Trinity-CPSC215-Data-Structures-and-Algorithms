package edu.trincoll.part4;
public interface Stack {

	  /** Reinitialize the stack.  The user is responsible for
	      reclaiming the storage used by the stack elements. */
	  public void clear();

	  /** Push an element onto the top of the stack.
	      @param it The element being pushed onto the stack. */
	  public void push(char it);

	  /** Remove and return the element at the top of the stack.
	      @return The element at the top of the stack. */
	  public char pop();

	  /** @return A copy of the top element. */
	  public char topValue();

	  /** @return The number of elements in the stack. */
	  public int length();
	  
	  public boolean isEmpty();
	};