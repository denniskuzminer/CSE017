/*
CSE 17 Fall 2019
@author Dennis Kuzminer
Homework #7
Program: GenericMatrixOperations
*/

import java.util.Arrays;

public class GenericMatrixOperations<E extends Number>
{
    /**
     * Substracts matrix B from matrix A
     * @param A Subtrahend
     * @param B Minuend
     * @return Difference
     */
    public SparseGenericMatrix<E> subtract(SparseGenericMatrix<E> A, SparseGenericMatrix<E> B) {
        Number[][] retMatrix = new Number[A.getNumRows()][A.getNumCols()];
        for(int i = 0; i < A.getNumRows(); i++) {
            for(int j = 0; j < A.getNumCols(); j++) {
                retMatrix[i][j] = (Number) (A.getVal(i, j).doubleValue() - B.getVal(i, j).doubleValue());
            }
        }
        return new SparseGenericMatrix(retMatrix);
    }

    /**
     * Adds matrix B to matrix A
     * @param A Addends
     * @param B Addends
     * @return Sum
     */
    public SparseGenericMatrix<E> add(SparseGenericMatrix<E> A, SparseGenericMatrix<E> B) {
        Number[][] retMatrix = new Number[A.getNumRows()][A.getNumCols()];
        for(int i = 0; i < A.getNumRows(); i++) {
            for(int j = 0; j < A.getNumCols(); j++) {
                retMatrix[i][j] = (Number) (A.getVal(i, j).doubleValue() + B.getVal(i, j).doubleValue());
            }
        }
        return new SparseGenericMatrix(retMatrix);
    }
}