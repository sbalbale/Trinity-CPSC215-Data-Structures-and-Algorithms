package edu.trincoll;
/**
 * Doubly Linked List Implementation
 * 
 * @param <E> The type of elements in this list.
 */
class DLink<E> {
    E element;
    DLink<E> next, prev;

    DLink(E it, DLink<E> prevVal, DLink<E> nextVal) {
        element = it;
        prev = prevVal;
        next = nextVal;
    }
}