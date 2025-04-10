package edu.trincoll.partB;

class Queue<T> {
    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> front;
    private Node<T> rear;

    public Queue() {
        front = rear = null;
    }

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T data = front.data;
        if (front == rear) {
            front = rear = null;
        } else {
            front = front.next;
        }
        return data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    // Method to delete specific element from the queue (if it exists)
    public void delete(T element) {
        if (isEmpty()) {
            return; // Queue is empty, nothing to delete
        }
        Node<T> current = front;
        Node<T> prev = null;
        // Iterate through the queue to find the element
        while (current != null) {
            if (current.data.equals(element)) {
                // Element found, delete it
                if (prev == null) {
                    front = current.next; // If element is at the front
                } else {
                    prev.next = current.next;
                    if (current.next == null) {
                        rear = prev; // If element is at the rear
                    }
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }

      // Method to search for an element in the queue
    public boolean search(T key) {
        Node<T> current = front;
        while (current != null) {
            if (current.data.equals(key)) {
                return true; // Element found
            }
            current = current.next;
        }
        return false; // Element not found
    }
}
