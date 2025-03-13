package edu.trincoll;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class NQueensTest {

    @Test
    public void testNQueensSolution() {
        // Test case with 3 queens
        int n = 3;
        NQueens nQueens = new NQueens();
        nQueens.solveNQueens(n);
        assertEquals(0, nQueens.getSolutionsCount());

        // Test case with 4 queens
        n = 4;
        nQueens.solveNQueens(n);
        assertEquals(2, nQueens.getSolutionsCount());

        // Test case with 8 queens
        n = 8;
        nQueens.solveNQueens(n);
        assertEquals(92, nQueens.getSolutionsCount());

    }
}