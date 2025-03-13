package edu.trincoll;

public class NQueens {
    private int solutionsCount;

    /**
     * Initializes the solving process for the N-Queens problem.
     *
     * @param n the size of the board (and the number of queens to place)
     */
    public void solveNQueens(int n) {
        solutionsCount = 0; // Reset the solutions count to 0 before starting
        int[] queens = new int[n]; // Create an array to store the column positions of queens for each row
        solve(0, n, queens); // Start solving from the first row
    }

    /**
     * Solves the N-Queens problem by placing queens on the board row by row.
     *
     * @param row    The current row to place a queen.
     * @param n      The size of the board (n x n) and the number of queens to
     *               place.
     * @param queens An array where the index represents the row and the value
     *               represents the column of the placed queen.
     */
    private void solve(int row, int n, int[] queens) {
        // If all queens are placed successfully, increment the solution count and print
        // the solution
        if (row == n) {
            solutionsCount++;
            printSolution(queens);
            return;
        }
        // Try placing a queen in each column of the current row
        for (int col = 0; col < n; col++) {
            // Check if placing a queen at (row, col) is valid
            if (isValid(row, col, queens)) {
                // Place the queen at (row, col)
                queens[row] = col;
                // Recur to place the rest of the queens
                solve(row + 1, n, queens);
            }
        }
    }

    /**
     * Checks if placing a queen at the given row and column is valid.
     *
     * @param row    The row index where the queen is to be placed.
     * @param col    The column index where the queen is to be placed.
     * @param queens An array where the index represents the row and the value at
     *               that index represents the column of the queen.
     * @return true if placing the queen at the specified row and column does not
     *         conflict with other queens, false otherwise.
     */
    private boolean isValid(int row, int col, int[] queens) {
        // Iterate over all previously placed queens
        for (int i = 0; i < row; i++) {
            // Check if a queen is already placed in the same column
            if (queens[i] == col ||
            // Check if a queen is placed on the same major diagonal
                    queens[i] - i == col - row ||
                    // Check if a queen is placed on the same minor diagonal
                    queens[i] + i == col + row) {
                return false; // Conflict found, not a valid position
            }
        }
        return true; // No conflicts, valid position
    }

    /**
     * Prints the current solution of the N-Queens problem.
     * Each solution is represented by an array where the index represents the row
     * and the value at that index represents the column position of the queen.
     *
     * @param queens an array representing the positions of queens on the board
     */
    private void printSolution(int[] queens) {
        // Print the solution number
        System.out.println("Solution " + solutionsCount);
        // Iterate over each row of the board
        for (int i = 0; i < queens.length; i++) {
            // Iterate over each column of the board
            for (int j = 0; j < queens.length; j++) {
                // Check if the queen is placed at the current column in the current row
                if (queens[i] == j) {
                    // Print 'Q' to represent the queen
                    System.out.print("Q ");
                } else {
                    // Print '-' to represent an empty space
                    System.out.print("- ");
                }
            }
            // Move to the next line after printing all columns of the current row
            System.out.println();
        }
        // Print an empty line to separate different solutions
        System.out.println();
    }

    /**
     * Returns the number of solutions found for the N-Queens problem.
     *
     * @return the count of solutions
     */
    public int getSolutionsCount() {
        return solutionsCount; // Return the total number of solutions found
    }
}
