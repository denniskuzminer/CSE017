import java.util.*;
import java.io.*;

public class ExceptionIBL
{
    public static void findInt(String inLine, PrintWriter output) {
        int num = -1;
        boolean hasSpecialChar = false;
        for(int i = 0; i < inLine.length(); i++) {
            if(inLine.charAt(i) >= 48 && inLine.charAt(i) <= 57) {
                num = inLine.charAt(i)-48;
                break;
            }
            if(inLine.charAt(i) >= 33 && inLine.charAt(i) <= 43) {
                hasSpecialChar = true;
                break;
            }
        }
        try {
            if(!(num == -1)) {
                output.println("The integer " + num + " has been found.");
            }
            if(hasSpecialChar) {
                throw new IllegalArgumentException();
            }
            if(num == -1) {
                throw new NoIntFoundException();
            }
        } catch (NoIntFoundException ex1) {
            output.println(ex1.getMessage());
        } catch (IllegalArgumentException ex2) {
            output.println("Your file contains a special character.");
        }
    }

    public static void main(String[] args) {
        Scanner input = null;
        PrintWriter output = null;

        try {
            File sourceFile = new File(args[0]);
            File outputFile = new File("outputFile.txt");
            input = new Scanner(sourceFile);
            output = new PrintWriter(outputFile);

            while(input.hasNextLine()) {
                String inLine = input.nextLine();
                findInt(inLine, output);
            }

        } catch (FileNotFoundException ex1) {
            System.out.println("NOTE: " + ex1.getMessage());
        } catch (ArrayIndexOutOfBoundsException ex2) {
            System.out.println("NOTE: " + ex2.getMessage());
        } finally {
            input.close();
            output.close();
        }
    }
}
class NoIntFoundException extends IllegalArgumentException
{
    public NoIntFoundException() {
        super("Your file contains no integers.");
    }
}