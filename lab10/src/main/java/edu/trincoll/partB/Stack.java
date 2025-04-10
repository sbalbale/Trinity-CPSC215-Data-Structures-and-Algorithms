package edu.trincoll.partB;

class Stack<T> {
    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> top;

    public Stack() {
        top = null;
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T data = top.data;
        top = top.next;
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    // Method to delete specific element from the stack (if it exists)
    public void delete(T element) {
        if (isEmpty()) {
            return; // Stack is empty, nothing to delete
        }
        if (top.data.equals(element)) {
            top = top.next; // If element is at the top of the stack
            return;
        }
        Node<T> current = top;
        Node<T> prev = null;
        // Iterate through the stack to find the element
        while (current != null) {
            if (current.data.equals(element)) {
                // Element found, delete it
                prev.next = current.next;
                return;
            }
            prev = current;
            current = current.next;
        }
    }
    
     // Method to search for an element in the stack
    public boolean search(T key) {
        Node<T> current = top;
        while (current != null) {
            if (current.data.equals(key)) {
                return true; // Element found
            }
            current = current.next;
        }
        return false; // Element not found
    }

}
