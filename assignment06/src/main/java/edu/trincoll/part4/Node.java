package edu.trincoll.part4;

// Node class for LinkedList
class Node<E> {
    E data;
    Node<E> next;

    Node(E data) {
        this.data = data;
        this.next = null;
    }
}
