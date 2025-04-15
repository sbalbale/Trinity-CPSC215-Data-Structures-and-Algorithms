package edu.trincoll;

public class RadixSort {
    
    public void sort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        
        // Find the maximum number to know number of digits
        int max = getMax(array);
        
        // Do counting sort for every digit
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(array, exp);
        }
    }
    
    private int getMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
    
    private void countingSort(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n];
        int[] count = new int[10];
        
        // Initialize count array
        for (int i = 0; i < 10; i++) {
            count[i] = 0;
        }
        
        // Store count of occurrences in count[]
        for (int i = 0; i < n; i++) {
            count[(array[i] / exp) % 10]++;
        }
        
        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        
        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }
        
        // Copy the output array to array[]
        for (int i = 0; i < n; i++) {
            array[i] = output[i];
        }
    }
}
