package edu.trincoll.part3;
/** Stack ADT */
public interface twoStack<E> {

//  /** Reinitialize the stack.  The user is responsible for
//      reclaiming the storage used by the stack elements. */
  public void clear();

  /** Push an element onto the top of the stack.
      @param it The element being pushed onto the respective stack. */
  public void push1(E it);
  public void push2(E it);

  /** Remove and return the element at the top of the stack.
      @return The element at the top of the respective stacks. */
  public E pop1();
  public E pop2();

//  /** @return A copy of the top element in respective stacks. */
  public E topValue1();
  public E topValue2();
  
//  /** @return The number of elements in respective stacks. */
  public int length1();
  public int length2();
};