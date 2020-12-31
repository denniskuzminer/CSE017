/*
CSE 17 Fall 2019
@author Dennis Kuzminer
Homework #8
Program: BubbleSort
*/


public class BubbleSort
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
            BubbleSort.bubbleSort(arr);
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
            BubbleSort.bubbleSort(arr);
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
            BubbleSort.bubbleSort(arr);
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            sum+=timeElapsed;
        }
        return sum/10;
    }

    /**
     * The rest of the program is taken from Professor Carr's BubbleSort algorithm
     */
    public static int bubbleSort(int[] list) {
        int iterations = 0;
        boolean needNextPass = true;
        for (int k=1; k < list.length && needNextPass; k++) {
            needNextPass = false;  // pass not needed until a swap
            // last k-1 elements are already sorted

            for (int i=0; i < list.length - k; i++) {
                if (list[i] > list[i+1]) {
                    // swap them
                    int temp = list[i];
                    list[i] = list[i+1];
                    list[i+1] = temp;
                    needNextPass = true;

                }

                iterations++;
            }
            //System.out.println(java.util.Arrays.toString(list));
        }
        return iterations;
    }
}