package sorting.algorithms;

/**
 * Comparison sort with O(n2) timing complexity making in-efficient on large sets.
 * In this algorithm the element on active position (say ith position) is compared with other positions
 * (say i+1th to nth position) and swaps if it's larger than the compared element. The compared element then becomes
 * the active element.
 * In this algorithm, a minimal element is found in the list and put in the start of the list.
 *
 * User: rpanjrath
 * Date: 8/20/13
 * Time: 2:54 PM
 */
public class SelectionSort {

    public int[] sort(int[] inputArray) {
        int arraylength = inputArray.length;
        int minIndex; // Current array index considered to be holding minimum value. Will be updated if other index holding lower value is found.
        int temp; // used for swapping.
        for (int i = 0; i < arraylength - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arraylength; j++) {
                if (inputArray[j] < inputArray[minIndex]) {
                    minIndex = j; // since index j is holding lower value, update minIndex to j.
                }
            }
            // Now minIndex is actually holding the lowest value in current sub-array.
            // if minIndex is i itself then dont swap. It means in the beginning only the selected element was smallest.
            if (minIndex != i) {
                temp = inputArray[i];
                inputArray[i] = inputArray[minIndex];
                inputArray[minIndex] = temp;
            }
        }
        return inputArray;
    }
}
