/** Program: FormatDemo.java *
  * Taken from Liang, Listing 4.6, p. 148 */

public class FormatDemo {
  public static void main(String[] args) {
    // Display the header of the table
    // note that a - before the width causes the value to be left-justified, as opposed to right-justified
    System.out.printf("%-10s%-10s%-10s%-10s%-10s\n", "Degrees", "Radians", "Sine", "Cosine", "Tangent");
    
    // Display values for 30 degreees
    int degrees = 30;
    double radians = Math.toRadians(degrees);
    // all of the value except the first are printed with 4 decimal places
    System.out.printf("%-10d%-10.4f%-10.4f%-10.4f%-10.4f\n", degrees, radians,
                      Math.sin(radians), Math.cos(radians), Math.tan(radians));
    
    // Display values for 60 degreees
    degrees = 60;
    radians = Math.toRadians(degrees);
    System.out.printf("%-10d%-10.4f%-10.4f%-10.4f%-10.4f\n", degrees, radians,
                      Math.sin(radians), Math.cos(radians), Math.tan(radians));
  }
}