/*
CSE 17 Fall 2019
@author Dennis Kuzminer
Homework #8
Program: MergeSort
*/

public class MergeSort
{

    /**
     * Creates an array of 10000 elements and fills it in random order
     * Then calculated the time it takes to sort it
     * Then repeats this 9 more times and then takes the average of these times
     * @return The average time it takes to sort through the list
     */
    public static long getAvgTimeRandom() {
        long sum = 0;
        int[] arr = new int[10000];
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < arr.length; j++) {
                arr[j] = (int)(Math.random()*10000);
            }
            long startTime = System.currentTimeMillis();
            MergeSort.mergeSort(arr);
            //MergeSort.mergeSort(arr, 0, arr.length-1);
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            sum+=timeElapsed;
        }
        return sum/10;
    }

    /**
     * Creates an array of 10000 elements and fills it in ascending order
     * Then calculated the time it takes to sort it
     * Then repeats this 9 more times and then takes the average of these times
     * @return The average time it takes to sort through the list
     */
    public static long getAvgTimeAscending() {
        long sum = 0;
        int[] arr = new int[10000];
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < arr.length; j++) {
                arr[j] = j;
            }
            long startTime = System.currentTimeMillis();
            MergeSort.mergeSort(arr);
            //MergeSort.mergeSort(arr, 0, arr.length-1);
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            sum+=timeElapsed;
        }
        return sum/10;
    }

    /**
     * Creates an array of 10000 elements and fills it in descending order
     * Then calculated the time it takes to sort it
     * Then repeats this 9 more times and then takes the average of these times
     * @return The average time it takes to sort through the list
     */
    public static long getAvgTimeDescending() {
        long sum = 0;
        int[] arr = new int[10000];
        for(int i = 0; i < 10; i++) {
            for(int j = arr.length-1, k = 0; j > 0 && k < arr.length-1; j--, k++) {
                arr[k] = j;
            }
            long startTime = System.currentTimeMillis();
            MergeSort.mergeSort(arr);
            //MergeSort.mergeSort(arr, 0, arr.length-1);
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            sum+=timeElapsed;
        }
        return sum/10;
    }

    /**
     * The rest of the program is taken from Professor Carr's MergeSort algorithm
     */
    public static void mergeSort(int[] list) {
        if (list.length > 1) {
            // BASE CASE: Merge two sorted arrays of
            //            length n/2

            // merge sort the first half
            int[] firstHalf = new int[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length/2);
            mergeSort(firstHalf);

            // merge sort the second half
            int secondHalfLength = list.length - list.length / 2;
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(list, list.length/2,
                    secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);

            // merge two halves
            merge(firstHalf, secondHalf, list);
        }
    }

    // Q: Is the merge method recursive?
    private static void merge(int[] list1, int[] list2, int[] temp) {
        /*System.out.println(java.util.Arrays.toString(list1));
        System.out.println(java.util.Arrays.toString(list2));*/
        // temp will store the merged list
        // Q: Why don't we have to return temp?
        int current1 = 0;   // index in list1
        int current2 = 0;   // index in list2
        int current3 = 0;   // index in temp
        while (current1 < list1.length && current2 < list2.length) {
            if (list1[current1] < list2[current2])
                temp[current3++] = list1[current1++];
            else
                temp[current3++] = list2[current2++];
        }
        while (current1 < list1.length)
            temp[current3++] = list1[current1++];
        while (current2 < list2.length)
            temp[current3++] = list2[current2++];
        //System.out.println(java.util.Arrays.toString(temp));
    }
}
