package edu.trincoll.part1;

class PriorityQueue<E extends Comparable<E>> {
    public static final int DEFAULT_CAPACITY = 10;
    public E[] array;
    public int size;

    @SuppressWarnings("unchecked")
    public PriorityQueue() {
        array = (E[]) new Comparable[DEFAULT_CAPACITY];
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public void ensureCapacity() {
        if (size == array.length) {
            E[] newArray = (E[]) new Comparable[array.length * 2];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    @SuppressWarnings("unchecked")
    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    public boolean isEmpty() {
        return size == 0;
    }

    @SuppressWarnings("unchecked")
    public void enqueue(E item) {
        ensureCapacity();
        array[size] = item;
        int current = size;
        size++;
        
        // Bubble up to maintain heap property
        while (current > 0) {
            int parentIndex = parent(current);
            if (array[current].compareTo(array[parentIndex]) >= 0) {
                break;
            }
            swap(current, parentIndex);
            current = parentIndex;
        }
    }

    @SuppressWarnings("unchecked")
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }
        
        E result = array[0];
        array[0] = array[size - 1];
        array[size - 1] = null;
        size--;
        
        if (!isEmpty()) {
            heapify(0);
        }
        
        return result;
    }

    @SuppressWarnings("unchecked")
    public E frontValue() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }
        return array[0];
    }

    public E printInfo(int n) {
        if (n < 0 || n >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return array[n];
    }

    @SuppressWarnings("unchecked")
    public int parent(int i) {
        return (i - 1) / 2;
    }

    @SuppressWarnings("unchecked")
    public void heapify(int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int smallest = i;
        
        if (left < size && array[left].compareTo(array[smallest]) < 0) {
            smallest = left;
        }
        
        if (right < size && array[right].compareTo(array[smallest]) < 0) {
            smallest = right;
        }
        
        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    @SuppressWarnings("unchecked")
    public void swap(int i, int j) {
        E temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
