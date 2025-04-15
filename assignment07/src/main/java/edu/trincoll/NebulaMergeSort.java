package edu.trincoll;

public class NebulaMergeSort<T extends Number & Comparable<T>> {
    private int comparisons = 0;

    public void sort(T[] array) {
        if (array == null || array.length <= 1) return;
        
        comparisons = 0;
        Object[] temp = new Object[array.length];
        nebulaMergeSort(array, temp, 0, array.length-1);
    }

    public int getComparisons() {
        return comparisons;
    }

    // Implement recursive merge sort with density checks
    private void nebulaMergeSort(T[] array, Object[] temp, int left, int right) {
        // Base case: if subarray has 1 or fewer elements, it's already sorted
        if (left >= right) return;
        
        // Find the middle point to divide the array into two halves
        int mid = left + (right - left) / 2;
        
        // Recursively sort the two halves
        nebulaMergeSort(array, temp, left, mid);
        nebulaMergeSort(array, temp, mid + 1, right);
        
        // Merge the sorted halves using density awareness
        densityAwareMerge(array, temp, left, mid, right);
    }

    // Implement density-based merge decision
    private void densityAwareMerge(T[] array, Object[] temp, 
                                  int left, int mid, int right) {
        // Calculate density for left and right subarrays
        double leftDensity = calculateDensity(array, left, mid);
        double rightDensity = calculateDensity(array, mid + 1, right);
        
        // Calculate the absolute difference in densities
        double densityDifference = Math.abs(leftDensity - rightDensity);
        
        // Check if left is already less than right at boundary
        boolean alreadyOrdered = mid < right && array[mid].compareTo(array[mid + 1]) <= 0;
        comparisons++; // Count the boundary comparison
        
        if (alreadyOrdered) {
            // Subarrays are already in order, no need to merge
            return;
        } else if (densityDifference > 0.5) {
            // Significant density difference, use adaptive merge
            boolean leftIsLower = leftDensity < rightDensity;
            adaptiveMerge(array, temp, left, mid, right, leftIsLower);
        } else {
            // Similar densities, use standard merge
            standardMerge(array, temp, left, mid, right);
        }
    }

    // Implement optimized merge for ordered sections
    private void adaptiveMerge(T[] array, Object[] temp, int left, 
                              int mid, int right, boolean leftIsLower) {
        // Copy all elements to temp array
        for (int i = left; i <= right; i++) {
            temp[i] = array[i];
        }
        
        int i = left;     // Pointer for left subarray
        int j = mid + 1;  // Pointer for right subarray
        int k = left;     // Pointer for merged array
        
        if (leftIsLower) {
            // If left is generally lower density, prioritize elements from left
            while (i <= mid && j <= right) {
                comparisons++;
                if (getElement(temp, i).compareTo(getElement(temp, j)) <= 0) {
                    array[k++] = getElement(temp, i++);
                } else {
                    array[k++] = getElement(temp, j++);
                }
            }
        } else {
            // If right is generally lower density, prioritize elements from right
            while (i <= mid && j <= right) {
                comparisons++;
                if (getElement(temp, i).compareTo(getElement(temp, j)) < 0) {
                    array[k++] = getElement(temp, i++);
                } else {
                    array[k++] = getElement(temp, j++);
                }
            }
        }
        
        // Copy remaining elements
        while (i <= mid) {
            array[k++] = getElement(temp, i++);
        }
        
        while (j <= right) {
            array[k++] = getElement(temp, j++);
        }
    }

    // Implement standard merge with comparison counting
    private void standardMerge(T[] array, Object[] temp, 
                              int left, int mid, int right) {
        // Copy all elements to temp array
        for (int i = left; i <= right; i++) {
            temp[i] = array[i];
        }
        
        int i = left;     // Pointer for left subarray
        int j = mid + 1;  // Pointer for right subarray
        int k = left;     // Pointer for merged array
        
        // Standard merge logic
        while (i <= mid && j <= right) {
            comparisons++;
            if (getElement(temp, i).compareTo(getElement(temp, j)) <= 0) {
                array[k++] = getElement(temp, i++);
            } else {
                array[k++] = getElement(temp, j++);
            }
        }
        
        // Copy remaining elements from left subarray
        while (i <= mid) {
            array[k++] = getElement(temp, i++);
        }
        
        // Copy remaining elements from right subarray
        while (j <= right) {
            array[k++] = getElement(temp, j++);
        }
    }

    // Helper method - Implement density calculation
    private double calculateDensity(T[] array, int start, int end) {
        if (start > end) return 0.0;
        
        double sum = 0.0;
        for (int i = start; i <= end; i++) {
            sum += array[i].doubleValue();
        }
        
        return sum / (end - start + 1);
    }

    @SuppressWarnings("unchecked")
    private T getElement(Object[] temp, int index) {
        return (T) temp[index];
    }
}