/*  8 QUEENS PROBLEM ALGORITHM :

Initialization : Initialize an empty chessboard of size 8 x 8


Backtracking Algorithm:

-- Start with column 0

-- For each row in the current column

-- Check if it's safe to place a queen at the current row and column

-- Check for conflicts with queens in the same row, same column, and diagonals

-- If it's safe, place the queen at the current position

-- Recur to the next column (col + 1) until all queens are placed

-- If a solution is found (all queens are placed), return true

-- If no solution is found in the current column, backtrack by removing the last placed queen and try the next row

-- If no solution is found after trying all rows in the column, return false

Safety Check Function:

-- Given a position (row, col), check if it's safe to place a queen there

-- Check for conflicts with queens in the same row, same column, and diagonals

-- Print Function:

Print the final configuration of the chessboard if a solution is found

Main Function:

-- Initialize the chessboard

-- Call the backtracking algorithm starting from column 0

-- If a solution is found, print it; otherwise, print that no solution exists


*/

import java.util.*;

public class EightQueens {

    static final int N = 8; // chessboard size

    // Function to solve the 8 queens problem
    public static boolean solveNQueens(int[][] board, int col) {
        // Base case: if all queens are placed, return true
        if (col >= N)
            return true;

        for (int i = 0; i < N; i++) {
            // Check if the queen can be placed on board[i][col]
            if (isSafe(board, i, col)) {

                // Place the queen
                board[i][col] = 1;

                // Recur to place the rest of the queens

                if (solveNQueens(board, col + 1))
                    return true;

                // If placing queen in board[i][col] doesn't lead to a solution,
                // backtrack and remove the queen from board[i][col]

                board[i][col] = 0; // Backtrack
            }
        }

        return false;
    }

    // Helper function to check if a queen can be placed on board[row][col]
    static boolean isSafe(int[][] board, int row, int col) {
        int i, j;
    
        // Check this row on the left side
        for (j = 0; j < col; j++) {

            if (board[row][j] == 1)
                return false;
        }
    
        // Check upper diagonal
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {

            if (board[i][j] == 1)
                return false;
        }
    
        // Check lower diagonal
        for (i = row, j = col; j >= 0 && i < N; i++, j--) {

            if (board[i][j] == 1)
                return false;
        }
    
        return true;
    }
    
    // Function to print the chessboard
    static void printBoard(int[][] board) {

        for (int[] row : board) {

            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {

        int[][] board = new int[N][N]; 


        if (solveNQueens(board, 0)) {

            System.out.println("Solution :");
            printBoard(board); // Print the solution
        } 
        
        else {
            System.out.println("No solution ");
        }

    }

}
