package edu.trincoll.part2;
// package P2;

public interface Stack<E> {
    // Add an element to the top of the stack
    void push(E obj);

    // Remove and return the top element from the stack
    E pop();

    // Return the size of the stack
    int size();
}
