package sorting.algorithms;

/**
 * Starting from the beginning of the list, compare every adjacent pair, swap their position if they are not in the
 * right order (the latter one is smaller than the former one).
 * After each iteration, one less element (the last one) is needed to be compared until there are no more elements
 * left to be compared.
 * If at least one swap has been done, repeat step 1.
 *
 * It puts biggest element at the end of the list and decreases the list size by 1, to be compared.
 *
 * http://www.algolist.net/Algorithms/Sorting/Bubble_sort
 * http://upload.wikimedia.org/wikipedia/commons/c/c8/Bubble-sort-example-300px.gif
 *
 * User: rpanjrath
 * Date: 8/20/13
 * Time: 2:55 PM
 */
public class BubbleSort {

    public int[] sort(int[] inputArray) {
        int arrayLength = inputArray.length;
        int j = 0;
        int temp;
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < arrayLength - j; i++) {
                if (inputArray[i] > inputArray[i + 1]) {
                    temp = inputArray[i];
                    inputArray[i] = inputArray[i + 1];
                    inputArray[i + 1] = temp;
                    swapped = true;
                }
            }
        }
        return inputArray;
    }
}
