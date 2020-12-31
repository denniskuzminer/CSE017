/**
 * CSE 17 Fall 2019
 * @author Dennis Kuzminer
 * Program 2
 * Program: EightQueens
 */

import java.util.*;

public class EightQueens
{

    public boolean[][] board;
    public boolean[] upDiagEmpty;
    public boolean[] downDiagEmpty;
    public boolean[] colEmpty;
    public int n;

    public EightQueens(int n) {
        this.n = n;
        this.board = new boolean[n][n];
        this.colEmpty = new boolean[n];
        this.upDiagEmpty = new boolean[n * 2 - 1];
        this.downDiagEmpty = new boolean[n * 2 - 1];

        // Fills with true
        Arrays.fill(this.colEmpty, true);
        Arrays.fill(this.upDiagEmpty, true);
        Arrays.fill(this.downDiagEmpty, true);
    }

    public static void main(String[] args) {
        try {

            int n = Integer.parseInt(args[0]);
            if(n < 0 || n > 9) {
                throw new IllegalArgumentException();
            }
            EightQueens query = new EightQueens(n);
            boolean solnExists = query.findSolution(0);
            if (!solnExists) {
                System.out.println("");
            }
        } catch (IllegalArgumentException ex1) {
            System.out.println("Must be between 1 and 8");
        } catch (InputMismatchException ex2) {
            System.out.println("");
        }
    }

    /**
     * Finds the solution recursively
     * @param row Starts at 0
     * @return false if no solution true if there is a solution
     */
    public boolean findSolution(int row) {
        // Base case. if the row goes up to size then it has checked all the rows and should print solution
        if(row == n) {
            printSolution();
            // Stops code
            return true;
        }
        for(int col = 0; col < board.length; col++) {
            if(isSafe(row, col)) {
                // If it is safe to place it, it will place a queen in that spot and will recursively call EightQueens again
                // If the code does not  work then it will backtrack and remove the queen
                placeQueen(row, col);
                findSolution(row + 1);
                removeQueen(row, col);
            }
        }
        return false;
    }

    /**
     * Figures out if the spot is safe
     * @param row Current row
     * @param col Current column
     * @return True if queen is not being attacked
     */
    public boolean isSafe(int row, int col) {
        return colEmpty[col] && upDiagEmpty[row + col] && downDiagEmpty[n - 1 + row - col];
    }

    /**
     * Places queen in spot if is safe... redundant but whateves
     * @param row Row to place it in
     * @param col Column to place it in
     */
    public void placeQueen(int row,int col) {
        if(isSafe(row, col)){
            board[row][col] = true;
            colEmpty[col] = false;
            upDiagEmpty[row + col] = false;
            downDiagEmpty[n - 1 + row - col] = false;
        }
    }

    /**
     * Removes queen in spot
     * @param row Row to removes it in
     * @param col Column to removes it in
     */
    public void removeQueen(int row, int col) {
        board[row][col] = false;
        colEmpty[col] = true;
        upDiagEmpty[row + col] = true;
        downDiagEmpty[n - 1 + row - col] = true;
    }

    /**
     * Prints a solution
     * if true --> Q
     * if false --> *
     */
    public void printSolution() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j]) {
                    System.out.print("Q  ");
                } else {
                    System.out.print("*  ");
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
