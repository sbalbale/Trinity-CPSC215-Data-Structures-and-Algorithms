package edu.trincoll;

import java.util.HashMap;
import java.util.Map;

public class GalacticRadixSort {
    
    // Main sorting entry point
    public void sort(int[] array) {
        if (array == null || array.length == 0) return;
        
        // Handle duplicates first for optimization
        if (handleDuplicates(array)) {
            return; // If duplicates were handled efficiently, we're done
        }
        
        // Handle negative numbers
        int offset = handleNegatives(array);
        
        // Sort with hexadecimal radix
        hexRadixSort(array);
        
        // Revert offset if needed
        if (offset > 0) {
            for (int i = 0; i < array.length; i++) {
                array[i] -= offset;
            }
        }
    }
    
    // Implement hexadecimal radix sort
    private void hexRadixSort(int[] array) {
        int max = getMax(array);
        
        // Use base-16 (hexadecimal) instead of base-10
        for (int exp = 1; max/exp > 0; exp *= 16) {
            countingSort(array, exp);
        }
    }
    
    // Modify for base-16
    private void countingSort(int[] array, int exp) {
        int[] output = new int[array.length];
        int[] count = new int[16]; // Change to 16 for hexadecimal
        
        // Count occurrences of each hex digit
        for (int num : array) {
            count[(num/exp) % 16]++;
        }
        
        // Calculate cumulative count
        for (int i = 1; i < 16; i++) {
            count[i] += count[i-1];
        }
        
        // Build output array
        for (int i = array.length-1; i >= 0; i--) {
            output[count[(array[i]/exp) % 16] - 1] = array[i];
            count[(array[i]/exp) % 16]--;
        }
        
        System.arraycopy(output, 0, array, 0, array.length);
    }
    
    // Helper method - modified for negative number handling
    private int getMax(int[] array) {
        int max = array[0];
        for (int num : array) {
            if (num > max) max = num;
        }
        return max;
    }
    
    // Implement negative number handling
    private int handleNegatives(int[] array) {
        // Find minimum value
        int min = array[0];
        for (int num : array) {
            if (num < min) min = num;
        }
        
        // If minimum is negative, add offset to make all values non-negative
        int offset = 0;
        if (min < 0) {
            offset = -min;
            for (int i = 0; i < array.length; i++) {
                array[i] += offset;
            }
        }
        
        return offset;
    }
    
    // Implement duplicate optimization
    private boolean handleDuplicates(int[] array) {
        // Check if there are enough duplicates to justify optimization
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : array) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // If duplicates are less than 25% of array size, don't optimize
        if (frequencyMap.size() > array.length * 0.75) {
            return false;
        }
        
        // Extract unique values
        int[] uniqueValues = new int[frequencyMap.size()];
        int index = 0;
        for (int key : frequencyMap.keySet()) {
            uniqueValues[index++] = key;
        }
        
        // Sort unique values
        if (uniqueValues.length > 1) {
            // Recursively sort the unique values
            sort(uniqueValues);
        }
        
        // Reconstruct the array with sorted unique values
        index = 0;
        for (int value : uniqueValues) {
            int frequency = frequencyMap.get(value);
            for (int i = 0; i < frequency; i++) {
                array[index++] = value;
            }
        }
        
        return true;
    }
}