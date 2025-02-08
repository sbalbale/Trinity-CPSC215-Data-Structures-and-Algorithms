package Lab1;

/**
 * A class to compute and print Fibonacci numbers below a specified limit.
 */
public class FibonacciSequence {

    /**
     * Prints all Fibonacci numbers under the specified value.
     *
     * @param n the maximum value for the Fibonacci sequence
     */
    public void printFibonacciUnder(int n) {
        int first = 0;
        int second = 1;
        System.out.println("The Fibonacci sequence is being displayed:");
        while (first < n) {
            System.out.print(first + " ");
            int sum = first + second;
            first = second;
            second = sum;
        }
        System.out.println();
        // Step 1: Initialize two variables to represent the first two numbers in the Fibonacci sequence.
        // Hint: The first two Fibonacci numbers are usually 0 and 1.

        // Step 2: Print a header or message indicating that the Fibonacci sequence is being displayed.

        // Step 3: Use a loop to generate Fibonacci numbers until the current number exceeds or equals n.
        // Hint: In each iteration, calculate the next number by adding the previous two numbers.

        // Step 4: Print the current Fibonacci number if it's less than n.
        // Hint: You can use a print statement within the loop.

        // Step 5: Update the variables to shift to the next pair of Fibonacci numbers.
        // Hint: The new number becomes the sum, and the older number gets replaced by the more recent one.

        // Step 6: Ensure you print all numbers in the sequence on the same line, separated by spaces.
        // Hint: Use a space (" ") between numbers while printing, and print a newline after the loop ends.
    }
}
