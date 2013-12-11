package sorting.test;

import sorting.algorithms.BubbleSort;
import sorting.algorithms.InsertionSort;
import sorting.algorithms.QuickSort;
import sorting.algorithms.SelectionSort;

/**
 * Sorting Algorithm Properties:
 * adaptive (performance adapts to the initial order of elements);
 * stable (insertion sort retains relative order of the same elements);
 * in-place (requires constant amount of additional space);
 * online (new elements can be added during the sort).
 *
 * Main class to execute all algorithms.
 * User: rpanjrath
 * Date: 8/20/13
 * Time: 2:56 PM
 */
public class TestSorting {

    public static void main(String[] args) {
        TestSorting testSorting = new TestSorting();
        int[] inputArray = {6, 3, 4, 5, 10, 8, 99, 0};

        BubbleSort bubbleSort = new BubbleSort();
        int[] bubbleSortedArray = bubbleSort.sort(inputArray);
//        testSorting.printResults(bubbleSortedArray);

        SelectionSort selectionSort = new SelectionSort();
        int[] selectionSortedArray = selectionSort.sort(inputArray);
//        testSorting.printResults(selectionSortedArray);

        InsertionSort insertionSort = new InsertionSort();
        int[] insertionSortedArray = insertionSort.sort(inputArray);
//        testSorting.printResults(insertionSortedArray);

        QuickSort quickSort = new QuickSort();
        int[] quickSortedArray = quickSort.sort(inputArray);
//        testSorting.printResults(quickSortedArray);

    }

    private void printResults(int[] sortedArray) {
        for (int i = 0; i < sortedArray.length; i++) {
            System.out.println(sortedArray[i]);
        }
    }
}
