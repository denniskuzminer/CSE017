import java.util.*;
//import java.util.Arrays;
//import java.util.Scanner;

/**
 * IBL1 
 * @author Dennis Kuzminer
 */

public class IBL1
{
  /**
   * main method is pretty much
   * the same as was in the instructions
   */
  public static void main(String[] args){
    
    Scanner scnr = new Scanner(System.in);
    System.out.println("Enter a string to search for in your input array.");
    String key = scnr.nextLine();
    detectWord(args, key);

    
    containsNumber(args);
    
    readWrite(scnr);
    
    
    System.out.println("Enter two strings to put in alphabetical order:");
    String[] alphaArray = new String[2];
    System.out.println("Enter the first string:");
    alphaArray[0] = scnr.nextLine();
    System.out.println("Enter the second string:");
    alphaArray[1] = scnr.nextLine();
    alphaOrder(alphaArray);
    
    nameGame(scnr);

  }
 
  
  
  /**
   * Checks to see if key is an elem of stringArr and prints its index
   * @param stringArr The phrase or in this case whatever is inputted on the command line
   * @param key The word that is being searched for
   */
  
  
  public static void detectWord(String[] stringArr, String key){
    //assumes that the word is not in stringArr unless it is found in the loop
    boolean isTheWordFound = false;
    for(int i = 0; i < stringArr.length; i++){
      if(stringArr[i].equals(key)){
        //accounts for only the first instance of the word
        System.out.println("Your indicated word was found at index " + i + " in your String array.");
        //set to true so the code below does not run
        isTheWordFound = true;
      }
    }
    if(!isTheWordFound){
      System.out.println("Your indicated word was not found in your String array.");
    }  
  }
  
  
  /**
   * Checks to see if there is a digit in stringArr
   * @param stringArr The inputted string array in this case command line 
   * Prints out whether each word has a digit
   */
  
  public static void containsNumber(String[] stringArr){
    for(int i = 0; i < stringArr.length; i++){
      //i assumed a word would not have a digit
      boolean hasDigit = false;
      for(int j = 0; j < stringArr[i].length();j++){
        //loops through each letter an checks if it is a digit
        if(Character.isDigit(stringArr[i].charAt(j))){
          hasDigit = true;
        }
      }
      if(hasDigit){
        System.out.println("Pass code at index " + i + " contains a digit.");
      }
      if(!hasDigit){
        System.out.println("Pass code at index " + i + " does not contain a digit.");
      }
    }
  }
    
  /**
   * Takes input and removes all white space from text and prints it
   * @param scnr Scans for the phrase to modify
   */
  
  public static void readWrite(Scanner scnr){
    while(true){
      //loops forever until there is some white space 
      System.out.println("Enter a string containing at least one whitespace.");
      String str = scnr.nextLine();
      //if there is a white space replace all of it with an empty string
      if(str.indexOf(" ") != -1){
        System.out.println("Your two strings, with no whitespace:");
        System.out.println(str.replaceAll(" ",""));
        break;
      }
      if(str.indexOf(" ") == -1){
        System.out.println("Error: No whitespace in string.");
      }
    }
  }
  
  /**
   * Takes an string array, sorts it, concatinates it, prints it in alphabetical order
   * Then, takes that and stores it into another array 
   * @param stringArr The inputted strings from the main 
   * @return returnArr The concatinated string is put into an array
   */
  
  public static String[] alphaOrder(String[] stringArr){
    Arrays.sort(stringArr);
    System.out.println("Your two strings, concatenated in alpha order:");
    System.out.println(stringArr[0] + stringArr[1]);
    String[] returnArr = new String[1];
    returnArr[0] = stringArr[0] + stringArr[1];
    return returnArr;
  }
  
  
  /**
   * Takes the inputted first name and replaces the 
   * first letter with "Banana-fana fo-f"
   * @param scnr Scans for first name
   */
  
  public static void nameGame(Scanner scnr){
    System.out.println("Input your first name: ");
    String name = scnr.nextLine();
    System.out.println("Banana-fana fo-f" + name.substring(1, name.length()));
  }
}