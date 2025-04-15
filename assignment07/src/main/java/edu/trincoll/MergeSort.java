package edu.trincoll;

public class MergeSort<T extends Comparable<T>> {
    
    public void sort(T[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        
        T[] temp = (T[]) new Comparable[array.length];
        mergeSort(array, temp, 0, array.length - 1);
    }
    
    private void mergeSort(T[] array, T[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(array, temp, left, mid);
            mergeSort(array, temp, mid + 1, right);
            merge(array, temp, left, mid, right);
        }
    }
    
    private void merge(T[] array, T[] temp, int left, int mid, int right) {
        // Copy both parts into the temporary array
        for (int i = left; i <= right; i++) {
            temp[i] = array[i];
        }
        
        int i = left;
        int j = mid + 1;
        int k = left;
        
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= mid && j <= right) {
            if (temp[i].compareTo(temp[j]) <= 0) {
                array[k] = temp[i];
                i++;
            } else {
                array[k] = temp[j];
                j++;
            }
            k++;
        }
        
        // Copy the rest of the left side of the array into the target array
        while (i <= mid) {
            array[k] = temp[i];
            k++;
            i++;
        }
        
        // Since we've already copied the right side elements in the first loop,
        // we don't need to copy the remaining right side elements
    }
}
