package Lab1;
import java.util.Scanner;

/**
 * A class to test the FibonacciSequence logic.
 */
public class FibonacciSequenceTest {

    public static void main(String[] args) {

        // Step 1: Create a Scanner object to read user input from the console.
        Scanner scanner = new Scanner(System.in);

        // Step 2: Prompt the user to enter the value of n.
        System.out.print("Enter the maximum value (n): ");

        // Step 3: Use the Scanner object to read the input and store it in an integer variable.
        int n = scanner.nextInt();

        // Step 4: Close the Scanner object to prevent resource leaks.
        scanner.close();

        // Step 5: Create an object of the FibonacciSequence class.
        FibonacciSequence fibonacciSequence = new FibonacciSequence();

        // Step 6: Use the created object to call the printFibonacciUnder method and pass the value of n as an argument.
        fibonacciSequence.printFibonacciUnder(n);

        // Step 7: Test the program with different values of n to ensure it works correctly.
        // Hint: For example, test with n = 10, 50, or 100 and check the output.
    }
}