import java.util.*;

public class matrixMultiplication {

    public static void main(String[] args) {

        int[][] matrix1 = { {1, 2, 3},
                            {4, 5, 6},
                            {7, 8, 9}} ;

        int [][] matrix2 = { {9, 8, 7},
                            {6, 5, 4},
                            {3, 2, 1} };

        int [][] result = multiplyMatrices(matrix1, matrix2);

        displayMatrix(result);

    }

    public static int [][] multiplyMatrices(int [][] matrix1, int [][] matrix2) {

        int rowsA = matrix1.length;
        int colsA = matrix1[0].length;
        int colsB = matrix2[0].length;

        int [][] result = new int [rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {

            for (int j = 0; j < colsB; j++) {

                for (int k = 0; k < colsA; k++) {

                    result[i][j] += matrix1[i][k] * matrix2[k][j];

                }

            }

        }

        return result;
    }

    public static void displayMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[0].length; j++) {

                System.out.print(matrix[i][j]);

                if (j < matrix[0].length - 1) {
                    System.out.print(", ");
                }
            }
            
            System.out.println();
        }
    }
}
