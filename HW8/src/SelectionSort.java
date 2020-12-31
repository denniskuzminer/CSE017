/*
CSE 17 Fall 2019
@author Dennis Kuzminer
Homework #8
Program: SelectionSort
*/

public class SelectionSort
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
            SelectionSort.selectionSort(arr);
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
            for(int j = arr.length-1, k = 0; j > 0 && k < arr.length-1; j--, k++) {
                arr[k] = j;
            }
            long startTime = System.currentTimeMillis();
            SelectionSort.selectionSort(arr);
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
            for(int j = arr.length-1; j > 0; j--) {
                arr[j] = j;
            }
            long startTime = System.currentTimeMillis();
            SelectionSort.selectionSort(arr);
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            sum+=timeElapsed;
        }
        return sum/10;
    }

    /**
     * The rest of the program is taken from Professor Carr's SelectionSort algorithm
     */
    public static void selectionSort(int[] table) {
        int n = table.length;
        for (int fill = 0; fill < n - 1; fill++) {
            int posMin = fill;
            for (int next = fill + 1; next < n; next++) {
                if (table[next]>table[posMin]) {
                    posMin = next;
                }
            }
            // Exchange table[fill] and table[posMin].
            int temp = table[fill];
            table[fill] = table[posMin];
            table[posMin] = temp;
        }
    }
}
