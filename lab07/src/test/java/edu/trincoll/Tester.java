package edu.trincoll;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the chessboard (n): ");

        int n = scanner.nextInt();
        if (n <= 3)
            System.out.println("No solutions found!");
        else {
            NQueens nQueens = new NQueens();
            System.out.println();
            nQueens.solveNQueens(n);
            System.out.println("Total Solutions = " + nQueens.getSolutionsCount());
        }

        scanner.close();
    }

}
