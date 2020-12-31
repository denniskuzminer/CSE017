import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class WordWrapper {

    public final static int LINE_MAX = 50;


    public static void main(String[] args) throws Exception {

        if(args.length != 2) {
            System.out.println("Usage: java Word Wrapper source target");
            System.exit(1);
        }

        File sourceFile = new File(args[0]);
        File targetFile = new File(args[1]);
        Scanner input = new Scanner(sourceFile);
        PrintWriter output = new PrintWriter(targetFile);

        while(input.hasNextLine()) {
            String inLine = input.nextLine();
            wrapOneLine(inLine, output);
        }

        input.close();
        output.close();
    }

    public static void wrapOneLine(String inLine, PrintWriter output) {
        for(int i = 0; i < inLine.length(); i += LINE_MAX) {
            if(i+LINE_MAX < inLine.length()) {
                output.println(inLine.substring(i, i + LINE_MAX));
            }
            else {
                output.println(inLine.substring(i));
            }
        }
    }
}