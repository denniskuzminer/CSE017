/** This class demonstrates how all primitive datatype parameters in 
  * Java are "pass-by-value." */
public class PassByValueDemo {
  
  /** This method is intended to swap the values of parameters a and b. */
  public static void swap(int a, int b) {
    int temp = a;
    a = b;
    b = temp;
    System.out.println("a = " + a);
    System.out.println("b = " + b);
  }
  
  public static void main(String[] args) {
    
    int x = 1;
    int y = 9;
    swap(x,y);
    System.out.println("x = " + x);
    System.out.println("y = " + y);
  }
}