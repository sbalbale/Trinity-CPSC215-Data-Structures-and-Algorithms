package edu.trincoll.part3;
import java.util.*;

class twoStacks<E> implements twoStack<E>
{
  E[] arr;
  int arr_size;
  int top1, top2, size;
  int size1 = 0, size2 = 0;
 
  // Constructor
  @SuppressWarnings("unchecked")
  twoStacks(int size)
  {
    // Initialize the array with the given size
    arr_size = size;
    arr = (E[]) new Object[size];
    top1 = -1; // Stack1 starts from left side
    top2 = size; // Stack2 starts from right side
  }
 
  // Method to push an element x to stack1
  public void push1(E x)
  {
    // Check if there is space between the two stacks
    if (top1 < top2 - 1) {
      top1++;
      arr[top1] = x;
      size1++;
    } else {
      System.out.println("Stack Overflow");
    }
  }
 
  // Method to push an element x to stack2
  public void push2(E x)
  {
    // Check if there is space between the two stacks
    if (top1 < top2 - 1) {
      top2--;
      arr[top2] = x;
      size2++;
    } else {
      System.out.println("Stack Overflow");
    }
  }
 
  // Method to pop an element from first stack
  public E pop1()
  {
    if (top1 >= 0) {
      E x = arr[top1];
      top1--;
      size1--;
      return x;
    } else {
      System.out.println("Stack Underflow");
      return null;
    }
  }
 
  // Method to pop an element from second stack
  public E pop2()
  {
    if (top2 < arr_size) {
      E x = arr[top2];
      top2++;
      size2--;
      return x;
    } else {
      System.out.println("Stack Underflow");
      return null;
    }
  }

  @Override
  public void clear() {
    // Reset both stacks
    top1 = -1;
    top2 = arr_size;
    size1 = 0;
    size2 = 0;
  }

  @Override
  public E topValue1() {
    if (top1 >= 0) {
      return arr[top1];
    } else {
      System.out.println("Stack1 is empty");
      return null;
    }
  }

  public E topValue2() {
    if (top2 < arr_size) {
      return arr[top2];
    } else {
      System.out.println("Stack2 is empty");
      return null;
    }
  }

  @Override
  public int length1() {
    return size1;
  }

  @Override
  public int length2() {
    return size2;
  }
}