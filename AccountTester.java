/*
CSE 17 Fall 2019
@author Dennis Kuzminer
Program 2
Program: AccountTester
*/

import java.io.*;
import java.util.*;

public class AccountTester
{
    public static void main(String[] args) {
        // Initializes a Scanner
        Scanner input = null;

        try {
            // Takes the command line arg and scans it
            File sourceFile = new File(args[0]);
            input = new Scanner(sourceFile);


            try {
                // First char is the type of account
                String accountType = input.next();

                // Gets the full name because the header for the account is done below
                String firstName = input.next();
                String lastName = input.next();
                String accountName = firstName + " " + lastName;

                // Asks for balance
                Scanner scnr = new Scanner(System.in);
                System.out.println("Account balance? ");
                double bal = scnr.nextDouble();

                // Header will show even if exception is thrown
                System.out.println("Invoice for: " + accountName);

                if (accountType.charAt(0) == 'G') {
                    // G = Grader
                    GraderExpense account = new GraderExpense(accountName, bal);

                    // Initializes charges... This is a consolidated list of all charges
                    // lineNum is just the number of lines after the first line which is the length of charges
                    int lineNum = 0;
                    ArrayList<Double> charges = new ArrayList<Double>();
                    while(input.hasNextLine()) {
                        lineNum++;
                        // Takes the next number and adds it to charges
                        charges.add(input.nextDouble());
                    }

                    // Prints the rest of the invoice
                    account.printInvoice(charges, lineNum);
                } else {
                    if (accountType.charAt(0) == 'E') {
                        // E = Faculty
                        FacultyExpense account = new FacultyExpense(accountName, bal);

                        // Initializes charges... This is a consolidated list of all charges
                        // lineNum is just the number of lines after the first line which is the length of charges
                        int lineNum = 0;
                        ArrayList<Double> charges = new ArrayList<Double>();
                        while(input.hasNextLine()) {
                            lineNum++;
                            // Takes the next number and adds it to charges
                            charges.add(input.nextDouble());
                        }

                        // Prints the rest of the invoice
                        account.printInvoice(charges, lineNum);
                    } else {
                        // If there is a different character at index 0 then it will not know what top create and will throw an exception
                        throw new UnknownAccountException();
                    }
                }
            } catch (AccountDepletedException ex1) {
                // Catches if there is insufficient funds
                 System.out.println(ex1.getMessage());
            } catch (UnknownAccountException ex2) {
                // Catches if the first character is not a valid char
                System.out.println(ex2.getMessage());
            }
        } catch (FileNotFoundException ex1) {
            // Catches if the file is found for the command line arg
            System.out.println("NOTE: " + ex1.getMessage());
        } finally {
            // Closes out the file
            input.close();
        }
    }
}