import java.util.Arrays;

public class LinearSearch<E extends Comparable<E>>
{
    public int linearSearchIter(E[] list, E key) {
        if(list.length-1 == 0) {
            return -1;
        }
        if(list[list.length-1] == key) {
            return list.length-1;
        }
        return linearSearchIter(Arrays.copyOf(list, list.length-1), key);
    }

    public static void main(String[] args) {
        Integer[] myArray1 = new Integer[10];
        for(int i = 0; i < 10; i++) {
            myArray1[i] = i*2;
        }
        LinearSearch<Integer> l = new LinearSearch<Integer>();
        System.out.println(l.linearSearchIter(myArray1, 14));
    }
}
