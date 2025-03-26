package edu.trincoll.part3;

class LinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public void add(E data) {
        Node<E> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public Node<E> getHead() {
        return head;
    }

    public int size() {
        return size;
    }

    public Node<E> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public void insertAfter(Node<E> prevNode, E data) {
        if (prevNode == null) {
            throw new IllegalArgumentException("Previous node cannot be null");
        }
        Node<E> newNode = new Node<>(data);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
        if (prevNode == tail) {
            tail = newNode;
        }
        size++;
    }
}