/*
CSE 17 Fall 2019
@author Dennis Kuzminer
Program 2
Program: GraderExpense
*/

import java.util.*;

public class GraderExpense extends ExpenseAccount
{
    /**
     * Creates a Grader Expense Account by calling the superclass constructor for the name and uses setBalance to alter private field
     * @param accountName Name associated with an account
     * @param balance Balance associated with an account
     */
    public GraderExpense(String accountName, double balance) {
        super(accountName);
        setBalance(balance);
    }

    /**
     * Prints all the charges made to the account
     * @param charges This is an ArrayList of all of the charges that made to the account
     * @param numCharges This is the number of charges made to the account
     *                   I know I could have just not had this an use charges.size() but I like to make my life complicated soOoOOoOOoOOOoOoOooOOOOOoOoo......ya
     */
    public void printInvoice(ArrayList<Double> charges, int numCharges) {
        //This method actually doesn't print the heading "Invoice for: " + accountName
        //      That is done in the main method

        //Loops for the number of charges
        for(int i = 0; i < numCharges; i++) {
            //Makes a payment with the corresponding charge and changes the balance
            makePayment(charges.get(i));
            // Checks for insufficient balance first
            if(getBalance() < 0) {
                throw new AccountDepletedException();
            }
            System.out.println("Department Grader account was charged $" + charges.get(i) + ".");
        }
    }
}