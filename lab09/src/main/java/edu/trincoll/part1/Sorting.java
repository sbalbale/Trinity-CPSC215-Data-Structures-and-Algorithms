package edu.trincoll.part1;
/**
 * Class containing various sorting algorithms.
 */
public class Sorting {

     /**
     * Sorts the given array using the Bubble Sort algorithm.
     * 
     * @param arr The array to be sorted.
     */
    public static void bubbleSort(int[] arr) {
        // Implementation of Bubble Sort algorithm
        // O(n^2) time complexity
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    
    /**
     * Sorts the given array using the Insertion Sort algorithm.
     * 
     * @param arr The array to be sorted.
     */
    public static void insertionSort(int[] arr) {
        // Implementation of Insertion Sort algorithm
        // O(n^2) time complexity
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    /**
     * Sorts the given array using the Shell Sort algorithm.
     * 
     * @param arr The array to be sorted.
     */
    public static void shellSort(int[] arr) {
        // Implementation of Shell Sort algorithm
        // O(n log n) time complexity
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i += 1) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    /**
     * Sorts the given array using the Merge Sort algorithm.
     * 
     * @param arr The array to be sorted.
     * @param temp An auxiliary array used for merging.
     * @param left The starting index of the subarray to be sorted.
     * @param right The ending index of the subarray to be sorted.
     */
    public static void mergeSort(int[] arr, int[] temp, int left, int right) {
        // Implementation of Merge Sort algorithm
        // O(n log n) time complexity
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, temp, left, mid);
            mergeSort(arr, temp, mid + 1, right);
            merge(arr, temp, left, mid, right);
        }
    }

    // Helper method for merge sort
    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }
        while (i <= mid) {
            arr[k++] = temp[i++];
        }
    }

    /**
     * Sorts the given array using the Quick Sort algorithm.
     * 
     * @param arr The array to be sorted.
     * @param low The starting index of the subarray to be sorted.
     * @param high The ending index of the subarray to be sorted.
     */
    public static void quickSort(int[] arr, int low, int high) {
        // Implementation of Quick Sort algorithm
        // O(n log n) time complexity (average case)
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Helper method for quick sort
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    /**
     * Sorts the given array using the Heap Sort algorithm.
     * 
     * @param arr The array to be sorted.
     */
    public static void heapSort(int[] arr) {
        // Implementation of Heap Sort algorithm
        // O(n log n) time complexity
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    // Helper method for heap sort
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }
}
