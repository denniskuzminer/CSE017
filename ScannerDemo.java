import java.util.Scanner;

/** This class demonstrates how to use the scanner class. */
public class ScannerDemo {
  
  public static void main(String[] args) {
    
    // Create a scanner that takes input from the standard input device
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter an integer: ");
    int i = input.nextInt();
    System.out.println("Entered " + i);
    
    System.out.print("Enter a float: ");
    float f = input.nextFloat();
    System.out.println("Entered " + f);
    
    System.out.print("Enter a line: ");
    String word1 = input.next();
    String word2 = input.next();
    String line = input.nextLine();
    System.out.println("First word is: " + word1);
    System.out.println("Second word is: " + word2);
    System.out.println("Rest of line is: " + line);
  }
}