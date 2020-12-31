/*
CSE 17 Fall 2019
@author Dennis Kuzminer
Homework #6
Program: PermutationsK
*/

import java.util.InputMismatchException;

public class PermutationsK
{

    // All variables are public cuz why not
    public String alpha;
    public int n;
    public int k;

    /**
     * Builds a PermutationK object by building an alphabet with length of n. E.g. n = 5 --> ABCDE
     * @param n Length of alphabet. n > 26 or n < 0
     * @param k Length of the combinations
     */
    public PermutationsK(int n, int k) {
        this.n = n;
        this.k = k;
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
        if(i == j) {
            return str;
        }
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
     * Creates all Permutations of alpha with length K
     * @param start Should be empty string at first but will change with recursion
     * @param alpha Alpha string
     */
    public void permutationKAlphabet(String start, String alpha) {
        for(int i = 0; i < alpha.length(); i++) {
            // Appends the chars to empty string
            // Makes alpha equal to alpha with the character at position i removed
            // And loops over
            permutationKAlphabet(start + alpha.charAt(i), alpha.substring(0, i) + alpha.substring(i + 1));
            // Only prints out the ones that are the length of k
            // i == 0 is just for filtering purposes
            if(start.length() == k && i == 0) {
                System.out.println(start);
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

            // Converts String to int and sets it to n and k
            int n = Integer.parseInt(args[0]);
            int k = Integer.parseInt(args[1]);

            PermutationsK permutationk = new PermutationsK(n, k);
            permutationk.permutationKAlphabet("", permutationk.alpha);

            // Catches the problems
        } catch (IllegalArgumentException ex1) {
            System.out.println("Parameter 'n' must be within the bounds of the alphabet. n > 26 or n < 0. Do not use ASCII or chars, only type ints.");
        } catch (InputMismatchException ex2) {
            System.out.println("Only a String of length 1 or 2 will work as the command-line arguments.");
        }
    }

}
