/*
Nitin Gupta
HW00

Vector Math Program
 */

import java.util.Scanner;

public class HW00 {

    public static final Scanner keyboard = new Scanner(System.in); // static Scanner

    public static void main(String[] args) {

        boolean play = true;
        while(play)
        {

            System.out.println("\nThis program performs a variety of vector math operations." +
                    "\nPress 1 to add vectors" +
                    "\nPress 2 to subtract vectors" +
                    "\nPress 3 to find the magnitude of a vector" +
                    "\nPress 4 to quit");
            int input = keyboard.nextInt();
            keyboard.nextLine(); // fix-up

            switch (input)
            {
                case (1):
                    addition();
                    if (!runAgain()) // don't want to run again
                        play = false;
                    break;
                case (2):
                    subtraction();
                    if (!runAgain()) // don't want to run again
                        play = false;
                    break;
                case (3):
                    magnitude();
                    if (!runAgain()) // don't want to run again
                        play = false;
                    break;
                case (4): //quit
                    play = false;
                    System.out.println("Bye!");
                    break;
                default: // wrong input
                    System.out.println("Input is wrong. Try again!");
            }

        }

    }

    private static int[] vectorInput(int vectorNumber)
    {
        boolean correctValue = false;

        while (!correctValue)
        {
            System.out.println("Enter the size of vector " + (vectorNumber) );
            int size1 = keyboard.nextInt();
            keyboard.nextLine(); // fix-up

            if (size1 >= 1) // Correct length
            {
                correctValue = true;

                int[] vec1 = new int[size1]; // initialize array
                for (int i = 0; i<size1; i++)
                {
                    System.out.println("Enter the value in the vector at " + (i+1));
                    vec1[i] = keyboard.nextInt();
                    keyboard.nextLine(); // fix-up
                }

                return vec1;
            }
            else // size wrong
            {
                System.out.println("The size of the vector is wrong and must be greater " +
                        "than or equal to 1.\nPlease try again");
            }
        }

        return new int[0]; // The code never actually reaches this. Done to not show error
    }

    private static void addition()
    {
        boolean correctMagnitude = false;

        while(!correctMagnitude)
        {
            int[] vector1 = vectorInput(1);
            int[] vector2 = vectorInput(2);

            if (vector1.length == vector2.length) // The magnitude is correct
            {
                correctMagnitude = true;

                int[] vectorSum = new int[vector1.length]; // New vector
                for (int i = 0; i<vectorSum.length; i++)
                {
                    vectorSum[i] = vector1[i] + vector2[i]; // Add to new vector
                }

                printVector(vectorSum);
            }
            else // Magnitude is incorrect
            {
                System.out.println("The lengths of the two vectors don't match." +
                        "\nPlease try again.");
            }
        }

    }

    private static void subtraction()
    {
        boolean correctMagnitude = false;

        while(!correctMagnitude)
        {
            int[] vector1 = vectorInput(1);
            int[] vector2 = vectorInput(2);

            if (vector1.length == vector2.length)
            {
                correctMagnitude = true;

                int[] vectorSum = new int[vector1.length];
                for (int i = 0; i<vectorSum.length; i++)
                {
                    vectorSum[i] = vector1[i] - vector2[i]; //add
                }

                printVector(vectorSum);
            }
            else
            {
                System.out.println("\nThe lengths of the two vectors don't match." +
                        "\nPlease try again.");
            }
        }

    }

    private static void magnitude()
    {
        int[] vector1 = vectorInput(1);

        int vectorMag = 0;
        for (int i = 0; i<vector1.length; i++)
        {
            vectorMag += Math.pow(vector1[i], 2); //square
        }

        System.out.println("Your output vector is:");
        System.out.println( Math.sqrt(vectorMag) ); // square root the sum of the squared

    }

    private static void printVector(int[] aVector)
    {
        System.out.println("Your output vector is:");
        for (int i = 0; i<aVector.length; i++)
        {
            System.out.println(aVector[i]);
        }
    }

    private static boolean runAgain()
    {
        boolean toQuit = false;
        while(!toQuit)
        {
            System.out.println("\nDo you want to... " +
                    "\nRun the program again? Enter 1" +
                    "\nOr quit? Enter 2");
            int inputRun = keyboard.nextInt();
            keyboard.nextLine();

            switch (inputRun)
            {
                case (1):
                    return true;
                case (2):
                    return false;
                default:
                    System.out.println("Invalid input");
            }
        }

        return false;
    }

}
