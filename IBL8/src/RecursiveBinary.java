public class RecursiveBinary {
    public static int binarySearch(int[] list, int key, int low, int high){
        while(high >= low) {
            int mid = (low + high)/2;
            if(key < list[mid]) {
                high = mid-1;
            }
            else if(key == list[mid]) {
                return mid;
            }
            else {
                low = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] myList = {2, 4, 7, 9, 10, 11, 19, 29, 30};
        int key = 29;
        int indKey = binarySearch(myList, key, 0, myList.length-1);
        System.out.println(indKey);
    }
}

