/*
CSE 17 Fall 2019
@author Dennis Kuzminer
Homework #7
Program: SparseGenericMatrix
*/

import java.util.Arrays;

public class SparseGenericMatrix<E extends Number>
{
    private E[][] matrix;
    private int[] rowArray;
    private int[] colArray;
    private E[] valArray;
    private int numElements;
    private int numRows;
    private int numCols;

    /**
     * Constructs a SparseGenericMatrix given a 2D array of a generic type bounded by Number
     * @param matrix 2D array to make into ijk notation
     */
    public SparseGenericMatrix(E[][] matrix) {
        this.matrix = matrix;
        // This just calculates how many non zero elems there are
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(!(matrix[i][j].equals(0))) {
                    numElements++;
                }
            }
        }

        // INstantiates the arrays
        rowArray = new int[numElements];
        colArray = new int[numElements];
        valArray = (E[]) new Number[numElements];

        // Fills the row, col, and valarray
        int curElem = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(!(matrix[i][j].equals(0))) {
                    rowArray[curElem] = i;
                    colArray[curElem] = j;
                    valArray[curElem] = matrix[i][j];
                    curElem++;
                }
            }
        }
        this.numRows = matrix.length;
        this.numCols = matrix[0].length;
    }

    //Getters
    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public int getNumElements() {
        return numElements;
    }

    /**
     * Prints out the ijk
     */
    public void printijk() {
        System.out.println("rowArray: " + Arrays.toString(rowArray));
        System.out.println("colArray: " + Arrays.toString(colArray));
        System.out.println("valArray: " + Arrays.toString(valArray));
    }

    /**
     * Gets the value at a row and col by getting the info from row, col, and valarray (i,j,k)
     * @param row Row to find the num at
     * @param col Col to find the num at
     * @return The value at a particular col and row but if no row and col matches then it means that there is a zero there
     * Because thats just how ijk notation works
     */
    public Number getVal(int row, int col) {
        for(int i = 0; i < this.getNumElements(); i++) {
            if((rowArray[i] == row) && (colArray[i] == col)) {
                return valArray[i];
            }
        }
        return 0;
    }

    /**
     * toString calls printijk
     */
    public String toString() {
        printijk();
        return Arrays.deepToString(matrix);
    }
}