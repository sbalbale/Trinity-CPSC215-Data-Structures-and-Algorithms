package edu.trincoll.partB;

class Heap<T extends Comparable<T>> {
    private static final int MAX_SIZE=1000000;
    private Object[] array;
    private int size;

    public Heap(int MAX_SIZE) {
        array = new Object[MAX_SIZE];
        MAX_SIZE = MAX_SIZE;
        size = 0;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private void swap(int i, int j) {
        T temp = (T) array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void insert(T data) {
        if (size > MAX_SIZE) {
            System.out.println(size);
            throw new IllegalStateException("Heap is full");
        }
        array[size] = data;
        int currentIndex = size;
        size++;
        while (currentIndex > 0 && ((T) array[parent(currentIndex)]).compareTo((T) array[currentIndex]) < 0) {
            swap(parent(currentIndex), currentIndex);
            currentIndex = parent(currentIndex);
        }
    }

    public T extractMax() {
        if (size <= 0) {

            throw new IllegalStateException("Heap is empty");
        }
        T max = (T) array[0];
        array[0] = array[size - 1];
        size--;
        heapify(0);
        return max;
    }

    private void heapify(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int largest = i;
        if (left < size && ((T) array[left]).compareTo((T) array[largest]) > 0) {
            largest = left;
        }
        if (right < size && ((T) array[right]).compareTo((T) array[largest]) > 0) {
            largest = right;
        }
        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }

    public boolean search(T key) {
        return searchHelper(key, 0);
    }

    private boolean searchHelper(T key, int currentIndex) {
        if (currentIndex >= size) {
            return false; // Element not found
        }

        if (array[currentIndex].equals(key)) {
            return true; // Element found
        }

        // Recursively search in left and right subtrees
        return searchHelper(key, leftChild(currentIndex)) || searchHelper(key, rightChild(currentIndex));
    }
}
