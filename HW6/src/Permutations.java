/*
CSE 17 Fall 2019
@author Dennis Kuzminer
Homework #6
Program: Permutations
*/

import java.util.InputMismatchException;

public class Permutations
{
    // All variables are public cuz why not
    public String alpha;
    public int n;

    /**
     * Builds a Permutation object by building an alphabet with length of n. E.g. n = 5 --> ABCDE
     * @param n Length of alphabet. n > 26 or n < 0
     */
    public Permutations(int n) {
        this.n = n;
        buildAlpha();
    }

    /**
     * Swaps the letters in a word
     * @param str Word to swap
     * @param i Swap index i with index j
     * @param j Swap index i with index j
     * @return Swapped word
     */
    public String swapAtPositions(String str, int i, int j) {
        // If i and j are the same, do nothing
        if(i == j) {
            return str;
        }
        // Take the string up until index i and then place the character at j
        // Then put the part of the string from that point up until index j and then take the character at i
        // Then put the rest of the string
        return str.substring(0, i) + str.charAt(j) + str.substring(i + 1, j) + str.charAt(i) + str.substring(j + 1);
    }

    /**
     * Builds an alphabet with a length of n
     */
    public void buildAlpha() {
        alpha = "";
        for (int i = 0; i < n; i++) {
            // Uses the ASCII value and casts it to a char
            alpha = alpha + (char) (65 + i);
        }
    }

    /**
     * Gives all permutations of alpha
     * @param i The first index of alpha. Which is 0
     */
    public void permutationAlphabet(int i) {
        // Base case
        if(i == n-1) {
            System.out.println(alpha);
        }
        else {
            for (int k = i; k < n; k++) {
                /* Takes the first n-1 letters and keeps it the same
                then that number decrements and n-2 letters are static while the rest alternate
                For instance ABC|D --> Last char alternates then AB|CD --> Last 2 chars alternate
                Then switches the 2nd char and follows the logic above
                 */
                // Switches i and k in alpha
                alpha = swapAtPositions(alpha, i, k);
                // Calls itself but bringing i closer to n
                permutationAlphabet(i+1);
                alpha = swapAtPositions(alpha,i,k);
            }
        }
    }

    public static void main(String[] args) {
        try {
            /* Checks for some bad input
           - If the first command line arg has a length larger than 2
           - If the second command line arg has a length larger than 2
           - If the input is outside of the bounds of the alphabet
             */
            if (args.length == 2) {
                if (!(args[0].length() > 0 && args[0].length() < 3) || !(args[1].length() > 0 && args[1].length() < 3)) {
                    throw new InputMismatchException();
                }
            }
            if (!(args[0].length() > 0 && args[0].length() < 3)) {
                throw new InputMismatchException();
            }
            if(Integer.parseInt(args[0]) > 26 || Integer.parseInt(args[0]) <= 0) {
                throw new IllegalArgumentException();
            }

            // Converts String to int and sets it to n
            int n = Integer.parseInt(args[0]);

            Permutations permutation = new Permutations(n);
            permutation.permutationAlphabet(0);

            // Catches the problems
        } catch (IllegalArgumentException ex1) {
            System.out.println("Parameter 'n' must be within the bounds of the alphabet. n > 26 or n < 0. Do not use ASCII or chars, only type ints.");
        } catch (InputMismatchException ex2) {
            System.out.println("Only a String of length 1 or 2 will work as the command-line arguments.");
        }
    }
}
