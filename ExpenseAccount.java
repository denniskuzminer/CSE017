/*
CSE 17 Fall 2019
@author Dennis Kuzminer
Program 2
Program: ExpenseAccount
*/

import java.util.*;

public class ExpenseAccount
{
    private String accountName;
    private double balance;

    /**
     * Creates an account. This is the superclass but is never actually declared in the main method
     * @param accountName Name associated with an account
     */
    public ExpenseAccount(String accountName) {
        this.accountName = accountName;
    }

    /**
     * Getters and setters
     */
    public String getAccountName() {
        return accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Charges the account
     * @param charge Subtracts the charge from the balance and makes that equal to the new balance
     */
    public void makePayment(double charge) {
        balance -= charge;
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
            if(balance < 0) {
                throw new AccountDepletedException();
            }
            System.out.println("Department Expense account was charged $" + charges.get(i) + ".");
        }
    }
}