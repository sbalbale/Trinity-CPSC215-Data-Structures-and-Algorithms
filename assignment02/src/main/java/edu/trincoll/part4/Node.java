package edu.trincoll.part4;

/**
 * Represents a node in a singly linked list.
 * Each node contains data of generic type T and a reference to the next node.
 *
 * @param <T> the type of data stored in this node
 */
public class Node<T> {
    /** The data stored in this node */
    T data;
    
    /** Reference to the next node in the linked list */
    Node<T> next;

    /**
     * Constructs a new node with the specified data.
     * The next reference is initialized to null.
     *
     * @param data the data to be stored in this node
     */
    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}