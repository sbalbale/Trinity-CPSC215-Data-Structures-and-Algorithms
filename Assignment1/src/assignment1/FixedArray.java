package assignment1;

//FixedArray.java

public class FixedArray<T> {

    private T[] array; // Encapsulation: array is private
    private int size; // Encapsulation: size is private

    //

    // Constructor (Note how we declare an array of size capacity)
    // Completed
    public FixedArray(int capacity) {
        array = (T[]) new Object[capacity];
        size = 0;
    }

    // Getter for size (Abstraction: providing access without exposing internal
    // details)
    // Completed
    public int getSize() {
        return size;
    }

    // Method to display the elements of the array
    // Completed
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // Method to get an element at a given index
    public T get(int index) {
        return array[index];
    }

    // Method to insert an element into the array (at the end)
    // Need to complete
    public void insert(T element) {
        if (size < array.length) {
            array[size] = element;
            size++;
        } else {
            System.out.println("Array is full");
        }
    }

    // Method to remove an element from the array at a given index
    // Need to complete
    public void remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index");
            return;
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
    }

    // Method to swap two elements in the array
    // Need to complete
    public void swap(int index1, int index2) {
        if (index1 < 0 || index1 >= size || index2 < 0 || index2 >= size) {
            System.out.println("Invalid index");
            return;
        }
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    // Method to clear the array
    // Need to complete
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    // Note: You may implement additional helper methods

}
