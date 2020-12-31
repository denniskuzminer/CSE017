/**
 * Merge sort is code taken from one of my previous cs classes
 * Selection sort code is taken from one of my previous cs classes
 */

import java.util.*;

public class MergeSortMod
{
    public int[] arr;

    public int[] getArr() {
        return arr;
    }

    public MergeSortMod(int[] arr) {
        this.arr = arr;
    }

    public static void sort(int[] arr) {
        System.out.println("Unsorted Array: " + Arrays.toString(arr));
        if(arr.length > 20) {
            mergeSort(arr);
        }
        else {
            selectionSort(arr);
        }
    }

    public static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSortHelper(arr, 0, arr.length - 1, temp);
    }

    private static void mergeSortHelper(int[] arr, int from, int to, int[] temp) {
        if(to - from >= 1) {
            int mid = (from + to) / 2;
            mergeSortHelper(arr, from, mid, temp);
            mergeSortHelper(arr, mid + 1, to, temp);
            merge(arr, from, mid, to, temp);
        }
    }

    private static void merge(int[] arr, int from, int mid, int to, int[] temp) {
        int i = from;
        int j = mid + 1;
        int k = from;
        while(i <= mid && j <= to) {
            if(arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            }
            else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        while(i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }
        while(j <= to) {
            temp[k] = arr[j];
            j++;
            k++;
        }
        for(k = from; k <= to; k++) {
            arr[k] = temp[k];
        }
    }


    private static void selectionSort(int[] arr) {
        for(int curIndex = 0; curIndex < arr.length - 1; curIndex++) {
            int minIndex = findMin(arr, curIndex);
            swap(arr, curIndex, minIndex);
        }
    }
    private static int findMin(int[] arr, int startingIndex) {
        int minIndex = startingIndex;
        for(int i = minIndex; i < arr.length; i++) {
            if(arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }
    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void main(String[] args) {
        int[] array1 = {5, 6, 4, 8, 9, 7, 3, 1, 2};
        MergeSortMod list = new MergeSortMod(array1);
        MergeSortMod.sort(array1);
        System.out.println(Arrays.toString(list.arr));

        int[] array2 = {5, 3, 4, 1, 6, 2, 7, 20, 13, 12, 24, 8, 10, 9, 25, 19, 18, 16, 17, 21, 11, 14, 15, 22, 23};
        MergeSortMod list2 = new MergeSortMod(array2);
        MergeSortMod.sort(array2);
        System.out.println(Arrays.toString(list2.arr));
    }
}