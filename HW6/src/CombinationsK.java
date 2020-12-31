/*
CSE 17 Fall 2019
@author Dennis Kuzminer
Homework #6
Program: CombinationsK
*/

import java.util.InputMismatchException;

import java.util.*;

public class CombinationsK
{
    // All variables are public cuz why not
    public String alpha;
    public int n;
    public int k;

    /**
     * Builds a CombinationsK object by building an alphabet with length of n. E.g. n = 5 --> ABCDE
     * @param n Length of alphabet. n > 26 or n < 0
     * @param k Length of the combinations
     */
    public CombinationsK(int n, int k) {
        this.n = n;
        this.k = k;
        buildAlpha();
    }

    public void buildAlpha() {
        alpha = "";
        for (int i = 0; i < n; i++) {
            // Uses the ASCII value and casts it to a char
            alpha = alpha + (char) (65 + i);
        }
    }

    /**
     * Creates all combinations of the alphabet with length k
     * @param start Should be an empty string at first but will accumulate
     * @param alpha The alphabet string
     * @param k The length
     */
    public void combinationkAlphabet(String start, String alpha, int k) {
        // Stops the method
        if(alpha.length() < k) {
            return;
        }
        // Base case for when k is 1
        // Just prints out the letters
        if(k == 1) {
            for(int i = 0; i < alpha.length(); i++) {
                System.out.println(start + alpha.charAt(i));
            }
        }
        else {
            // Another base case for when k is the same as the length
            // Then this will just print out the letter in alphabetical order
            if(alpha.length() == k) {
                for(int i = 0; i < alpha.length(); i++) {
                    start += alpha.charAt(i);
                }
                System.out.println(start);
            }
            else {
                // For all the other 'normal' cases it locks the first letter in place by making start = start + the elem of alpha at i
                // Then skips over up until i + 1 and decrements k to make k hit base cases
                if(alpha.length() > k) {
                    for (int i = 0; i < alpha.length(); i++) {
                        combinationkAlphabet(start + alpha.charAt(i), alpha.substring(i + 1), k - 1);
                    }
                }
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

            CombinationsK combinationk = new CombinationsK(n, k);
            combinationk.combinationkAlphabet("", combinationk.alpha, k);

            // Catches the problems
        } catch (IllegalArgumentException ex1) {
            System.out.println("Parameter 'n' must be within the bounds of the alphabet. n > 26 or n < 0. Do not use ASCII or chars, only type ints.");
        } catch (InputMismatchException ex2) {
            System.out.println("Only a String of length 1 or 2 will work as the command-line arguments.");
        }
    }
}