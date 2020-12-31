/*
CSE 17 Fall 2019
@author Dennis Kuzminer
Homework #8
Program: QuickSort
*/

public class QuickSort
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
            QuickSort.quickSort(arr, 0, arr.length-1);
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
            QuickSort.quickSort(arr, 0, arr.length-1);
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
            QuickSort.quickSort(arr, 0, arr.length-1);
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            sum+=timeElapsed;
        }
        return sum/10;
    }


    /**
     * The rest of the program is taken from Professor Carr's QuickSort algorithm
     */
    public static void quickSort(int[] list) {
        quickSort(list, 0, list.length - 1);
    }
    /** Quick sort a sublist starting from first and ending with last */
    private static void quickSort(int[] list, int first, int last) {
        if (last > first) {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }
    private static int partition(int[] list, int first, int last) {
        int pivot = list[first];
        int low = first + 1;
        int high = last;
        while (high > low) {
            // look for leftmost element > pivot
            // the <= pivot below is need if there are dupes in list
            while (low <= high && list[low] <= pivot)
                low++;
            // look for rightmost element <= pivot
            while (low <= high && list[high] > pivot)
                high--;
            if (high > low) {                        // then swap
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }
        // find where pivot needs to be placed
        while (high > first && list[high] >= pivot)
            high--;
        // swap pivot with list[high]
        if (pivot > list[high]) {
            list[first] = list[high];
            list[high] = pivot;
            return high;
        }
        else
            return first;
    }
}
