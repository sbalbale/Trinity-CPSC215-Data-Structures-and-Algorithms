package edu.trincoll;

public class QuantumQuickSort<T extends Number & Comparable<T>> {

    public void sort(T[] array) {
        if (array == null || array.length == 0) return;
        quantumQuickSort(array, 0, array.length-1);
    }

    // Implement optimized quick sort
    private void quantumQuickSort(T[] array, int low, int high) {
        // Base case: if subarray has 1 or fewer elements, it's already sorted
        if (low >= high) return;
        
        // Select pivot using gravitational method
        int pivotIndex = selectGravitationalPivot(array, low, high);
        
        // Partition the array around the pivot
        int partitionPos = partition(array, low, high, pivotIndex);
        
        // Recursively sort the subarrays
        quantumQuickSort(array, low, partitionPos - 1);
        quantumQuickSort(array, partitionPos + 1, high);
    }

    // Implement gravitational pivot selection
    private int selectGravitationalPivot(T[] array, int low, int high) {
        // If range is too small, just return high
        if (high - low < 2) return high;
        
        // Choose three elements: low, middle, high
        int mid = low + (high - low) / 2;
        
        // Calculate weights for each element
        int lowWeight = calculateWeight(array[low]);
        int midWeight = calculateWeight(array[mid]);
        int highWeight = calculateWeight(array[high]);
        
        // Find the median weight and return its index
        if (lowWeight <= midWeight) {
            if (midWeight <= highWeight) return mid;      // low ≤ mid ≤ high
            else if (lowWeight <= highWeight) return high; // low ≤ high < mid
            else return low;                              // high < low ≤ mid
        } else {
            if (lowWeight <= highWeight) return low;      // mid < low ≤ high
            else if (midWeight <= highWeight) return high; // mid ≤ high < low
            else return mid;                              // high < mid < low
        }
    }

    // Calculate digit sum weight
    private int calculateWeight(T number) {
        // Convert to long value
        long value = number.longValue();
        
        // Take absolute value to handle negative numbers
        value = Math.abs(value);
        
        // Calculate sum of digits
        int sum = 0;
        while (value > 0) {
            sum += value % 10;  // Add the last digit
            value /= 10;        // Remove the last digit
        }
        
        return sum;
    }

    private int partition(T[] array, int low, int high, int pivotIndex) {
        T pivot = array[pivotIndex];
        swap(array, pivotIndex, high);
        
        int i = low-1;
        for (int j=low; j<high; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i+1, high);
        return i+1;
    }

    private void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}