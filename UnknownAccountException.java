/*
CSE 17 Fall 2019
@author Dennis Kuzminer
Program 2
Program: UnknownAccountException
*/

public class UnknownAccountException extends IllegalArgumentException
{
    /**
     * Special excpetion that has the message "Invalid account."
     */
    public UnknownAccountException() {
        super("Invalid account.");
    }
}