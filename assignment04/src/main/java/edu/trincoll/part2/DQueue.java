package edu.trincoll.part2;
// package P2;

public interface DQueue<E> extends Queue<E> {
    // Add an element to the beginning of the queue
    void insertFirst(E obj);

    // Add an element to the end of the queue
    void insertLast(E obj);

    // Remove and return the first element from the queue
    E removeFirst();

    // Remove and return the last element from the queue
    E removeLast();

    // Remove the specified number of elements from the beginning of the queue
    void truncate_first(int num);

    // Remove the specified number of elements from the end of the queue
    void truncate_last(int num);
}
