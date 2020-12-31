/*
CSE 17 Fall 2019
@author Dennis Kuzminer
Homework #8
Program: HeapSort
*/

import java.util.*;

public class HeapSort {

    /**
     * Creates an array of 10000 elements and fills it in random order
     * Then calculated the time it takes to sort it
     * Then repeats this 9 more times and then takes the average of these times
     * @return The average time it takes to sort through the list
     */
    public static long getAvgTimeRandom() {
        long sum = 0;
        int[] arr = new int[10000];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[j] = (int) (Math.random() * 10000);
            }
            long startTime = System.currentTimeMillis();
            HeapSort.heapSort(arr);
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            sum += timeElapsed;
        }
        return sum / 10;
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
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[j] = j;
            }
            long startTime = System.currentTimeMillis();
            HeapSort.heapSort(arr);
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            sum += timeElapsed;
        }
        return sum / 10;
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
        for (int i = 0; i < 10; i++) {
            for(int j = arr.length-1, k = 0; j > 0 && k < arr.length-1; j--, k++) {
                arr[k] = j;
            }
            long startTime = System.currentTimeMillis();
            HeapSort.heapSort(arr);
            long endTime = System.currentTimeMillis();
            long timeElapsed = endTime - startTime;
            sum += timeElapsed;
        }
        return sum / 10;
    }

    /**
     * The rest of the program is taken from Professor Carr's HeapSort algorithm
     */
    public static void heapSort(int[] list) {

        // Create a heap to store and organize the values. */
        Heap<Integer> heap = new Heap<Integer>();

        // add all elements to the heap
        for (int i = 0; i < list.length; i++)
            heap.add(list[i]);

        // remove the elements from the heap and add to list, from right to left
        for (int i = list.length - 1; i >= 0; i--)
            list[i] = heap.remove();
    }
}

class Heap<E extends Comparable<E>> {
    private ArrayList<E> list = new ArrayList<E>();

    /** No-arg constrcutors does nothing. */
    public Heap() {
    }

    /** Create a heap from an array of objects. */
    public Heap(E[] objects) {
        for (int i=0; i < objects.length; i++)
            add(objects[i]);
    }

    /** Add a new object to the heap. */
    public void add(E newObject) {
        list.add(newObject);      // put at end of the heap
        int currentIndex = list.size() - 1;

        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            // swap if current object is greater than its parent
            if (list.get(currentIndex).compareTo(list.get(parentIndex)) > 0) {
                E temp = list.get(currentIndex);
                list.set(currentIndex, list.get(parentIndex));
                list.set(parentIndex, temp);
            }
            else
                break;        // tree is now a heap
            currentIndex = parentIndex;
        }
    }

    /** Remove the root from the heap. */
    public E remove() {
        if (list.size() == 0) return null;

        E removedObject = list.get(0);
        // set root to last object
        list.set(0, list.get(list.size() -1));
        list.remove(list.size() - 1);

        int currentIndex = 0;
        while (currentIndex < list.size()) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            // find the max of the two children (if they exist)
            if (leftChildIndex >= list.size())
                break;                                // tree is a heap
            int maxIndex = leftChildIndex;
            if (rightChildIndex < list.size()) {
                if (list.get(maxIndex).compareTo(list.get(rightChildIndex)) < 0) {
                    maxIndex = rightChildIndex;
                }
            }

            // swap if the current node is less than the max
            if (list.get(currentIndex).compareTo(list.get(maxIndex)) < 0) {
                E temp = list.get(maxIndex);
                list.set(maxIndex, list.get(currentIndex));
                list.set(currentIndex, temp);
                currentIndex = maxIndex;
            }
            else
                break;      // tree is a heap;
        }
        return removedObject;
    }

    public int getSize() {
        return list.size();
    }
}