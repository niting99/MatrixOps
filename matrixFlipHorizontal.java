/*
Nitin Gupta
Lab 08

Matrix Flipped Horizontally
Write a program that creates and randomly populates a 10x10 matrix of integers,
and then flips the information horizontally.
 */

import java.util.Random;

public class matrixFlipHorizontal {

    public static final int MATRIX_SIZE = 10;
    public static final int RANDOM_BOUND = 10;

    public static void main(String[] args) {

        Random r = new Random();
        matrixFlipHorizontal m = new matrixFlipHorizontal(); //instance of the class itself

        int[][] matrix = m.randomMatrixCreator(MATRIX_SIZE, MATRIX_SIZE, r);
        int[][] flippedMatrix = m.matrixFlipper(matrix);

        System.out.println("Created Matrix");
        m.matrixPrinter(matrix);
        System.out.println("Matrix flipped horizontally");
        m.matrixPrinter(flippedMatrix);
    }

    /**
     * Creates a random matrix
     * @param rows (the number of rows)
     * @param columns (the number of columns)
     * @param rVar (the Random variable created in the main method)
     * @return randMatrix (a matrix filled randomly)
     */
    public int[][] randomMatrixCreator(int rows, int columns, Random rVar)
    {

        int[][] randMatrix = new int[rows][columns];

        for (int i = 0; i<randMatrix.length; i++)
        {
            for (int j = 0; j<randMatrix[i].length; j++)
            {
                randMatrix[i][j] = rVar.nextInt(RANDOM_BOUND);
            }
        }

        return randMatrix;
    }

    /**
     * Flips a given (from the parameter) matrix horizontally.
     * Swaps opposite column (starting from the outside ends) values from within a row.
     * @param matrixToFlip (the original matrix that needs flipping)
     * @return matrixFlipped (the new matrix, now flipped)
     */
    public int[][] matrixFlipper(int[][] matrixToFlip)
    {
        int[][] matrixFlipped = new int[matrixToFlip.length][matrixToFlip[0].length];

        for (int i = 0; i<matrixToFlip.length; i++)
        {
            for (int j = 0; j<matrixToFlip[i].length; j++)
            {

                matrixFlipped[i][ (matrixToFlip[0].length -1) - j ] = matrixToFlip[i][j];

            }
        }
        return matrixFlipped;
    }

    /**
     * Prints a given matrix
     * Doesn't return anything. Only prints.
     * @param matrix (the matrix that needs to be flipped)
     */
    public void matrixPrinter(int[][] matrix)
    {
        for (int i = 0; i<matrix.length; i++)
        {

            for (int j = 0; j<matrix[i].length; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
    }
}
