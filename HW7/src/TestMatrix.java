/*
CSE 17 Fall 2019
@author Dennis Kuzminer
Homework #7
Program: TestMatrix
*/

import java.util.Arrays;

public class TestMatrix {

    public static void main(String[] args) {
        Integer[][] sparseMatrix = { {0, 0, 2, 0, 1}, {0, 0, 1, 0, 2}, {0, 0, 0, 0, 5}, {0, 1, 0, 0, 0}, {1, 0, 0, 0, 0} };
        Integer[][] sparseMatrix2 = { {3, 0, 2, 0, 1}, {0, 0, 1, 0, 1}, {0, 5, 0, 0, 10}, {2, 7, 2, 0, 0}, {0, 0, 2, 0, 1} };

        System.out.println(Arrays.deepToString(sparseMatrix));

        System.out.println(Arrays.deepToString(sparseMatrix2));

        SparseGenericMatrix<Integer> matrix = new SparseGenericMatrix<Integer>(sparseMatrix);

        SparseGenericMatrix<Integer> matrix2 = new SparseGenericMatrix<Integer>(sparseMatrix2);

        // GenericMatrixOperations should be instantiated with the type of numbers you would like to perform operations on
        GenericMatrixOperations<Integer> operations = new GenericMatrixOperations<Integer>();

        // This should probably be static but whatever
        System.out.println(operations.add(matrix, matrix2));

        System.out.println(operations.subtract(matrix, matrix2));

        Double[][] sparseMatrix3 = { {3.0, 0.0, 2.0, 0.0, 1.0}, {0.0, 0.0, 1.0, 0.0, 1.0}, {0.0, 5.0, 0.0, 0.0, 10.0}, {2.0, 7.0, 2.0, 0.0, 0.0}, {0.0, 0.0, 2.0, 0.0, 1.0} };

        SparseGenericMatrix<Double> matrix3 = new SparseGenericMatrix<Double>(sparseMatrix3);

        GenericMatrixOperations<Double> operations2 = new GenericMatrixOperations<Double>();

        System.out.println(operations2.add(matrix3, matrix3));

        System.out.println(operations2.subtract(matrix3, matrix3));

        // Java assumes that the method for add or subtract has the same type of E. So two different types of E for A and B will not work
        //System.out.println(operations.add(matrix, matrix3));
    }
}
