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

    public void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSortHelper(arr, 0, arr.length - 1, temp);
    }

    private void mergeSortHelper(int[] arr, int from, int to, int[] temp) {
        if(to - from >= 1) {
            int mid = (from + to) / 2;
            mergeSortHelper(arr, from, mid, temp);
            mergeSortHelper(arr, mid + 1, to, temp);
            merge(arr, from, mid, to, temp);
            System.out.println(Arrays.toString(arr));
        }
    }

    private void merge(int[] arr, int from, int mid, int to, int[] temp) {
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


    private void selectionSort(int[] arr) {
        for(int curIndex = 0; curIndex < arr.length - 1; curIndex++) {
            int minIndex = findMin(arr, curIndex);
            swap(arr, curIndex, minIndex);
        }
    }
    private int findMin(int[] arr, int startingIndex) {
        int minIndex = startingIndex;
        for(int i = minIndex; i < arr.length; i++) {
            if(arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }
    private void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void main(String[] args) {
        int[] array1 = {5, 3, 4, 1, 6, 2};
        int[] array2 = {5, 6, 4, 8, 9, 7, 3, 1, 2};
        MergeSortMod list = new MergeSortMod(array2);
        MergeSortMod.sort(array2);
    }

}