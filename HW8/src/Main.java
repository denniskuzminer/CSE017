import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for(int j = arr.length-1, k = 0; j > 0 && k < arr.length-1; j--, k++) {
            arr[k] = j;
        }
        System.out.println(Arrays.toString(arr));

        int[] arr2 = new int[10];
        for(int j = 0; j < arr2.length; j++) {
            arr2[j] = j;
        }
        System.out.println(Arrays.toString(arr2));
    }
}
