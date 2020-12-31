 public class StringDemo {
  
  public static void main(String[] args) {

    int whatsleft = 0;
    boolean[] arr = new boolean[1000];
    for(int i = 0; i < 1000; i++) {
      for(int j = 0; j < 1000; i++) {
        if((j+1)%(i+1)==0) {
          arr[j] = !arr[j];
        }
      }
    }
    for(int i = 0; i < 1000; i++) {
      if(arr[i]) {
        whatsleft++;
      }
    }
    System.out.println(whatsleft);

    /*
    
    // s1 and s2 are interned strings, s3 is not
    String s1 = "Star Wars";
    String s2 = "Star Wars";
    String s3 = new String("Star Wars");
    
    System.out.println("s1==s2? " + (s1 == s2));
    System.out.println("s1==s3? " + (s1 == s3));
    
    System.out.println("s1.equals(s2)? " + (s1.equals(s2)));
    System.out.println("s1.equals(s3)? " + (s1.equals(s3)));
    
    String s4 = "Star Trek";
    System.out.println("Which is greater, " + s1 + " or " + s4 + "?");
    if (s1.compareTo(s4) > 0)
      System.out.println(s1);
    else if (s1.compareTo(s4) < 0)
      System.out.println(s4);
    else
      System.out.println("Neither. They are equal.");

    System.out.println("The last character of s1 is " + s1.charAt(s1.length() - 1));

    String prefix = s1.substring(0,4);
    System.out.println("First 4 chars of s1 are " + prefix);
    
    System.out.println("The first 'a' in s1 is at index " + s1.indexOf('a'));
    System.out.println("The last 'a' in s1 is at index " + s1.lastIndexOf('a'));

    System.out.println("Does s4 start with prefix '" + prefix + "'? " + s4.startsWith(prefix));
    System.out.println("Does s4 end with prefix '" + prefix + "'? " + s4.endsWith(prefix));


     */
  }
}