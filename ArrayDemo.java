/** This class demonstrates the usage of arrays. */
public class ArrayDemo {
  
  /** Find the index of a key value in the given array.
    * Return -1 if the key is not found. */
  public static int linearSearch(int[] list, int key) {
    
    for (int i=0; i < list.length; i++) {      
      if (list[i] == key)
        return i;
    }
    return -1;
  }
  

  /** Use binary search to find the index of the key value
    * in a sorted array. If the value is not found, returns the
    * (-i - 1) where i is the index of its insertion point. */
  public static int binarySearch(int[] list, int key) {
    int low = 0;
    int high = list.length - 1;
    
    while (high >= low) {
      int mid = (low + high) / 2;
      if (key < list[mid])
        high = mid - 1;
      else if (key == list[mid])
        return mid;
      else
        low = mid + 1;    
    }
    return -low - 1;
  }
  

  
  public static void main(String[] args) {
   
    int[] myArray = {1,3,6,7,8,9,11,14,18};
    
    System.out.println(linearSearch(myArray, 11));
    System.out.println(linearSearch(myArray, 4));
    System.out.println(linearSearch(myArray, 1));
    System.out.println(linearSearch(myArray, 18));
    
    System.out.println(binarySearch(myArray, 11));
    System.out.println(binarySearch(myArray, 4));
    System.out.println(binarySearch(myArray, 1));
    System.out.println(binarySearch(myArray, 18));
   
  }
  
}