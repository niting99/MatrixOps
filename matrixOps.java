/*
Nitin Gupta
10/8/21

Matrix Ops: Addition, Subtraction, Multiplication, Division
 */


import java.util.Scanner;

public class matrixOps {

    public static void main(String[] args) {

        System.out.println("Welcome to Matrix Operations." +
                "\n We can add, subtract, or multiply 2 matrices for you.");

        Scanner keyboard = new Scanner(System.in);
        matrixOps m = new matrixOps();

        boolean wrongMatrix = true;
        while (wrongMatrix)
        {
            double[][] inputMatrix1 = m.inputMatrix(keyboard, 1);
            double[][] inputMatrix2 = m.inputMatrix(keyboard, 2);

            boolean correctChoice = false;

            while (!correctChoice)
            {

                System.out.println("\nDo you want to do" +
                        "\nAdd? Press 1" +
                        "\nSubtract? Press 2" +
                        "\nMultiply? Press 3");
                double choice = keyboard.nextDouble();
                keyboard.nextLine();

                if (choice == 1) //addition
                {
                    correctChoice = true;

                    if (inputMatrix1.length == inputMatrix2.length
                            && inputMatrix1[0].length == inputMatrix2[0].length)
                    {
                        double[][] matrixAdded = m.matrixAdder(inputMatrix1, inputMatrix2);
                        m.matrixPrinter(matrixAdded);
                        wrongMatrix = false;
                    }

                    else
                    {
                        System.out.println("Invalid Dimensions.");
                        System.out.println("Try again");
                    }

                }

                else if (choice == 2) // subtraction
                {
                    correctChoice = true;

                    if (inputMatrix1.length == inputMatrix2.length
                            && inputMatrix1[0].length == inputMatrix2[0].length)
                    {
                        double[][] matrixSubtracted = m.matrixSubtracter(inputMatrix1, inputMatrix2);
                        m.matrixPrinter(matrixSubtracted);
                        wrongMatrix = false;
                    }

                    else
                    {
                        System.out.println("Invalid Dimensions.");
                        System.out.println("Try again");
                    }

                }

                else if (choice == 3) // multiplication
                {
                    correctChoice = true;

                    if (inputMatrix1[0].length == inputMatrix2.length)
                    {
                        double[][] matrixMultiplied = m.matrixMultiplier(inputMatrix1, inputMatrix2);
                        m.matrixPrinter(matrixMultiplied);
                        wrongMatrix = false;
                    }

                    else
                    {
                        System.out.println("Invalid Dimensions.");
                        System.out.println("Try again");
                    }
                }

                else
                {
                    System.out.println("Invalid input");
                    System.out.println("Please try again");
                }
            }
        }

    }

    public double[][] inputMatrix(Scanner key, int noOfMatrix)
    {

        System.out.println("\nEnter the size of the matrix " + noOfMatrix);

        System.out.println("Enter the number of rows");
        int row = key.nextInt();
        key.nextLine();

        System.out.println("Enter the number of columns");
        int column = key.nextInt();
        key.nextLine();

        double[][] matrix = new double[row][column];

        for (int i=0; i<matrix.length; i++)
        {

            for (int j=0; j<matrix[i].length; j++) // go up until the row length
            {
                    System.out.println("Enter the value at " + (i+1) + (j+1));
                    matrix[i][j] = key.nextDouble();
                    key.nextLine();
            }

        }

        return matrix;
    }

    public double[][] matrixAdder(double[][] matrix01, double[][]matrix02)
    {
        // create a matrix with the same length and width
        double[][] matrix03 = new double[matrix01.length][matrix01[0].length];

        // could have iterated over matrix02.length also because it is the same thing...
        for (int i = 0; i<matrix01.length; i++)
        {
            for (int j = 0; j<matrix01[i].length; j++)
            {
                matrix03[i][j] = matrix01[i][j] + matrix02[i][j];
            }
        }

        return  matrix03;
    }

    public double[][] matrixSubtracter(double[][] matrix01, double[][]matrix02)
    {
        // create a matrix with the same length and width
        double[][] matrix03 = new double[matrix01.length][matrix01[0].length];

        // could have iterated over matrix02.length also because it is the same thing...
        for (int i = 0; i<matrix01.length; i++)
        {
            for (int j = 0; j<matrix01[i].length; j++)
            {
                matrix03[i][j] = matrix01[i][j] - matrix02[i][j];
            }
        }

        return  matrix03;
    }

    public double[][] matrixMultiplier(double[][] matrix01, double[][]matrix02)
    {
        // create a matrix with the 1st rows and the 2nd columns
        double[][] matrix03 = new double[matrix01.length][matrix02[0].length];


        for (int i=0; i< matrix03.length; i++)
        {

            for (int j = 0; j< matrix03[i].length; j++)
            {

                for (int k =0; k< matrix02.length; k++)
                {
                    matrix03[i][j] += matrix01[i][k] * matrix02[k][j];
                }
            }

        }

        return  matrix03;
    }

    public void matrixPrinter(double[][] matrix)
    {
        System.out.println();

        for (int i = 0; i<matrix.length; i++)
        {

            for (int j = 0; j<matrix[0].length; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
    }

}
