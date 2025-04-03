package edu.trincoll.part1;

import java.util.Random;

/**
 * Class to test and record the timing of various sorting algorithms.
 */
public class SortTest {

    /**
     * Main method to run the sorting algorithms and record their timings.
     * 
     * @param args Command line arguments (not used in this program).
     *             Main Method: The main method is the entry point of the program.
     *             Inside the main method,
     *             the following steps are performed for each specified array size:
     *             o Generate a random array of N integers using the
     *             generateRandomArray method.
     *             o Copy the generated array using the copyArray method. This is
     *             done to ensure that
     *             each sorting algorithm sorts the same input array.
     *             o Record the start time using System.nanoTime().
     *             o Call each sorting algorithm with the copied array and record
     *             the execution time.
     *             o Output the execution time for each sorting algorithm.
     *             o Repeat these steps for each specified array size.
     */
    public static void main(String[] args) {
        int[] sizes = { 10, 100, 1000, 10000, 100000, 1000000 };

        // To do: Complete this.
        // You may use the helper methods below for completing this
        int startTime, endTime;
        for (int size : sizes) {
            System.out.println("Sorting array of size: " + size);
            // Generate a random array of the specified size
            int[] arr = generateRandomArray(size);
            int[] arrCopy;

            // Insertion Sort
            arrCopy = copyArray(arr);
            startTime = (int) System.nanoTime();
            Sorting.insertionSort(arrCopy);
            endTime = (int) System.nanoTime();
            System.out.println("Insertion Sort Time for size " + size + ": " + (endTime - startTime) + " ns");

            // Bubble Sort
            arrCopy = copyArray(arr);
            startTime = (int) System.nanoTime();
            Sorting.bubbleSort(arrCopy);
            endTime = (int) System.nanoTime();
            System.out.println("Bubble Sort Time for size " + size + ": " + (endTime - startTime) + " ns");

            // Shell Sort
            arrCopy = copyArray(arr);
            startTime = (int) System.nanoTime();
            Sorting.shellSort(arrCopy);
            endTime = (int) System.nanoTime();
            System.out.println("Shell Sort Time for size " + size + ": " + (endTime - startTime) + " ns");

            // Merge Sort
            arrCopy = copyArray(arr);
            startTime = (int) System.nanoTime();
            int[] temp = new int[arrCopy.length];
            Sorting.mergeSort(arrCopy, temp, 0, arrCopy.length - 1);
            endTime = (int) System.nanoTime();
            System.out.println("Merge Sort Time for size " + size + ": " + (endTime - startTime) + " ns");
            
            // Quick Sort
            arrCopy = copyArray(arr);
            startTime = (int) System.nanoTime();
            Sorting.quickSort(arrCopy, 0, arrCopy.length - 1);
            endTime = (int) System.nanoTime();
            System.out.println("Quick Sort Time for size " + size + ": " + (endTime - startTime) + " ns");
            
            // Heap Sort
            arrCopy = copyArray(arr);
            startTime = (int) System.nanoTime();
            Sorting.heapSort(arrCopy);
            endTime = (int) System.nanoTime();
            System.out.println("Heap Sort Time for size " + size + ": " + (endTime - startTime) + " ns");
            
            System.out.println("--------------------------------------------------\n");
        }

    }

    /**
     * Generates a random array of integers.
     * 
     * @param size The size of the array to be generated.
     * @return The generated array.
     */
    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt();
        }
        return arr;
    }

    /**
     * Creates a copy of the given array.
     * 
     * @param arr The array to be copied.
     * @return The copy of the array.
     */
    private static int[] copyArray(int[] arr) {
        int[] copy = new int[arr.length];
        System.arraycopy(arr, 0, copy, 0, arr.length);
        return copy;
    }
}
