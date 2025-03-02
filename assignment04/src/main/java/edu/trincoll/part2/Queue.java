package edu.trincoll.part2;
// package P2;

public interface Queue<E> {
    // Add an element to the end of the queue
    void enqueue(E obj);

    // Remove and return the first element from the queue
    E dequeue();

    // Return the size of the queue
    int size();
}
