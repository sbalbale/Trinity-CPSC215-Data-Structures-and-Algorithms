package edu.trincoll.part2;

/*

n is the size of the original array and k is the range of values.

Time Complexity: O(n+k) 

Space Complexity: O(k)

Not a super useful general algorithm since it only works with integers.
It also has a high space complexity


*/

public class Lab8P2 {

    public static void main(String[] args) {
        // int[] arr = { 9, 2, 4, 8, 9, 4, 3, 2, 8, 1, 2, 7, 2, 5 };
        int[] arr = { 9, 2, 4, 8, 9, 4, 3, 2, 8, 1, 2, 7, 2, 5, -6, -6, -6, -2, -4, 0 };
        System.out.print("Original Array: ");
        printArray(arr);

        int[] count = getCountArray(arr);
        System.out.print("Count Array: ");
        printArray(count);

        int[] sortedArr = countingSort(arr);
        System.out.print("Sorted Array: ");
        printArray(sortedArr);

    }

    /**
     * Sorts the given array using the Counting Sort algorithm.
     *
     * @param arr the array of integers to be sorted
     * @return the sorted array
     * @throws NullPointerException     if the input array is null
     * @throws IllegalArgumentException if the input array is empty
     */
    public static int[] countingSort(int[] arr) {
        int[] count = getCountArray(arr); // Get the count array
        int[] sortedArr = new int[arr.length]; // Create a new array for the sorted result
        int index = 0; // Index for the sorted array
        // Iterate through the count array and fill the sorted array
        for (int i = 0; i < count.length; i++) {
            // For each index in the count array, add the corresponding value to the sorted array
            // the number of times it appears in the original array
            for (int j = 0; j < count[i]; j++) {
                // Add the value to the sorted array
                // The value is adjusted by adding the minimum value of the original array
                sortedArr[index++] = i + findMin(arr);
            }   
        }
        return sortedArr;
    }

    /**
     * Generates the count array required for the counting sort algorithm.
     *
     * @param arr the array of integers to be sorted
     * @return the count array containing the frequency of each integer
     * @throws NullPointerException     if the input array is null
     * @throws IllegalArgumentException if the input array is empty
     */
    public static int[] getCountArray(int[] arr) {
        // Check for null or empty array
        if (arr == null) {
            throw new NullPointerException("Input array cannot be null");
        }
        if (arr.length == 0) {
            throw new IllegalArgumentException("Input array cannot be empty");
        }

        // Find the minimum and maximum values in the array and determine the range
        int min = findMin(arr);
        int max = findMax(arr);
        int range = max - min + 1;

        // Create the count array
        // The size of the count array is equal to the range of values in the original array
        int[] count = new int[range];
        for (int num : arr) {
            count[num - min]++;
        }
        return count;
        
    }

    /**
     * Finds and returns the maximum value in the given array of integers.
     *
     * @param arr the array of integers to search for the maximum value
     * @return the maximum value in the array
     * @throws NullPointerException     if the input array is null
     * @throws IllegalArgumentException if the input array is empty
     */
    public static int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }

        return max;
    }

    /**
     * Finds and returns the minimum value in the given array of integers.
     *
     * @param arr the array of integers to search for the minimum value
     * @return the minimum value in the array
     * @throws NullPointerException     if the input array is null
     * @throws IllegalArgumentException if the input array is empty
     */
    public static int findMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
        }

        return min;
    }

    /**
     * Prints the elements of the given integer array to the console in a single
     * line,
     * separated by commas. A newline is printed at the end.
     *
     * @param arr the array of integers to be printed
     */
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
