/**
 * "You may use the code available for any of the sorting algorithms on CourseSite"
 *
 *
 * QuickSort is taken from coursesite
 * Insertion sort is code taken from one of my previous cs classes
 */

import java.util.Arrays;

public class QuickSortMod {

    public int[] arr;

    public int[] getArr() {
        return arr;
    }

    public QuickSortMod(int[] arr) {
        this.arr = arr;
    }

    public static void sort(int[] arr) {
        System.out.println("Unsorted Array: " + Arrays.toString(arr));;
        if(arr.length > 20) {
            quickSort(arr);
        }
        else {
            insertionSort(arr);
        }
    }

    public static void quickSort(int[] list) {
        quickSort(list, 0, list.length - 1);
    }
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
            while (low <= high && list[low] <= pivot)
                low++;
            while (low <= high && list[high] > pivot)
                high--;
            if (high > low) {
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }
        while (high > first && list[high] >= pivot)
            high--;
        if (pivot > list[high]) {
            list[first] = list[high];
            list[high] = pivot;
            return high;
        }
        else
            return first;
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int curNumber = arr[i];
            int curIndex = i-1;
            while ( curIndex >= 0 && arr[curIndex] > curNumber) {
                arr[curIndex+1] = arr[curIndex];
                curIndex--;
            }
            arr[curIndex + 1] = curNumber;
        }
    }

    public static void main(String[] args) {
        int[] array1 = {5, 6, 4, 8, 9, 7, 3, 1, 2};
        QuickSortMod list = new QuickSortMod(array1);
        QuickSortMod.sort(array1);
        System.out.println(Arrays.toString(list.arr));

        int[] array2 = {5, 3, 4, 1, 6, 2, 7, 20, 13, 12, 24, 8, 10, 9, 25, 19, 18, 16, 17, 21, 11, 14, 15, 22, 23};
        QuickSortMod list2 = new QuickSortMod(array2);
        QuickSortMod.sort(array2);
        System.out.println(Arrays.toString(list2.arr));
    }
}
