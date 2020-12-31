public class QuickSortMod
{
    public int[] arr;

    public int[] getArr() {
        return arr;
    }

    public QuickSortMod(int[] arr) {
        this.arr = arr;
    }

    public static void sort(int[] arr) {
        System.out.println("Unsorted Array: " + arr);
        if(arr.length > 20) {
            quickSort(arr);
        }
        else {
            insertionSort(arr);
        }
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int curNumber = arr[i];
            int curIndex = i-1;
            while ( curIndex >= 0 && arr[curIndex] > curNumber) {
                arr[curIndex+1] = arr[curIndex];
                curIndex--;
            }
            arr[curIndex + 1] = curNumber;
        }
        System.out.println("Sorted Array: " + arr);
    }
}