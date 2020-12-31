/*
CSE 17 Fall 2019
@author Dennis Kuzminer
Homework #8
Program: SortingAnalysis
*/

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class SortingAnalysis {

    public static void main(String[] args) throws Exception{
        File sourceFile = new File("SortingStats.txt");
        PrintWriter output = new PrintWriter(sourceFile);

        output.println("Name of Sort \t Worst Case \t Best Case \tTic/Toc \t                   Tic/Toc \t                 Tic/Toc");
        output.println("                 \t Theoretical\t Theoretical\tRunning Time\t    Running Time\t  Running Time");
        output.println("                 \t Running Time\t Running Time\tDescending Order\t    Ascending Order\t  Randomly Sorted Order");
        output.println("------------------------------------------------------------------------------------------------------------------------------------------------");
        output.println("Selection\t \tO(n^2)\t\tO(n^2)\t\t" + SelectionSort.getAvgTimeDescending() + "\t\t    " + SelectionSort.getAvgTimeAscending() + "\t\t " + SelectionSort.getAvgTimeRandom() + "");
        output.println("Insertion\t \tO(n)\t\tO(n^2)\t\t"  + InsertionSort.getAvgTimeDescending() + "\t\t    " + InsertionSort.getAvgTimeAscending() + "\t\t " + InsertionSort.getAvgTimeRandom() + "");
        output.println("Bubble\t \tO(n)\t\tO(n^2)\t\t"  + BubbleSort.getAvgTimeDescending() + "\t\t    " + BubbleSort.getAvgTimeAscending() + "\t\t " + BubbleSort.getAvgTimeRandom() + "");
        output.println("Merge\t \tO(nlogn)\t\tO(nlogn)\t\t" + MergeSort.getAvgTimeDescending() + "\t\t    " + MergeSort.getAvgTimeAscending() + "\t\t " + MergeSort.getAvgTimeRandom() + "");
        output.println("Quick\t \tO(nlogn)\t\tO(n^2)\t\t" + QuickSort.getAvgTimeDescending() + "\t\t    " + QuickSort.getAvgTimeAscending() + " \t\t " + QuickSort.getAvgTimeRandom() + "");
        output.println("Heap\t \tO(n)\t\tO(nlogn)\t\t" + HeapSort.getAvgTimeDescending() + "\t\t    " + HeapSort.getAvgTimeAscending() + "\t\t " + HeapSort.getAvgTimeRandom() + "");
        output.println("\n\nIf the table doesn't format correctly just run it again.");
        output.println("Run the program a few times and the average times will change. All times are in milliseconds.");
        output.println("Most code implementation is taken off of the code that was provided to us from Prof Carr \nor https://stackabuse.com/sorting-algorithms-in-java/.");
        output.close();
    }
}