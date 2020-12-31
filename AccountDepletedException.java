/*
CSE 17 Fall 2019
@author Dennis Kuzminer
Program 2
Program: AccountDepletedException
*/

public class AccountDepletedException extends IllegalArgumentException
{
    /**
     * Special excpetion that has the message "Insufficient funds."
     */
    public AccountDepletedException() {
        super("Insufficient funds.");
    }
}