/*
CSE 17 Fall 2019
@author Dennis Kuzminer
Homework #6
Program: Combinations
*/

import java.util.InputMismatchException;

import java.util.*;

public class Combinations
{
    // All variables are public cuz why not
    public String alpha;
    public int n;

    /**
     * Builds a Combinations object by building an alphabet with length of n. E.g. n = 5 --> ABCDE
     * @param n Length of alphabet. n > 26 or n < 0
     */
    public Combinations(int n) {
        this.n = n;
        buildAlpha();
    }

    /**
     * Builds an alphabet with a length of n
     */
    public void buildAlpha() {
        alpha = "";
        for (int i = 0; i < n; i++) {
            alpha = alpha + (char) (65 + i);
        }
    }


    public ArrayList<Character> output1= new ArrayList<Character>();

    /**
     * Creates all combinations of varying length of the alphabet
     * @param start Should be zero at first when called but like all other variables named start in this program it will change
     */
    public void combinationAlphabet(int start) {
        for(int i = start; i < n; i++) {
            // Put chars into an arrayList (cuz why not make it harder for myself)
            output1.add(alpha.charAt(i));
            // Ripped this next line off the internet cuz all it is is making all the elements in output1 into a string with no commas or brackets
            String output2 = output1.toString().replaceAll("\\[|\\]", "").replaceAll(", ","");
            System.out.println(output2);
            /* If i is less than n
            Then run combinationAlphabet with bringing i closer to n and then
            Shrink the size of output1 by removing the last item
             */
            if(i < n) {
                combinationAlphabet( i + 1);
                output1.remove(output1.size() - 1);
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

            Combinations combination = new Combinations(n);
            combination.combinationAlphabet(0);

            // Catches the problems
        } catch (IllegalArgumentException ex1) {
            System.out.println("Parameter 'n' must be within the bounds of the alphabet. n > 26 or n < 0. Do not use ASCII or chars, only type ints.");
        } catch (InputMismatchException ex2) {
            System.out.println("Only a String of length 1 or 2 will work as the command-line arguments.");
        }
    }

}
