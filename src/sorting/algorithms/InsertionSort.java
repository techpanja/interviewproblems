package sorting.algorithms;

/**
 * March up the array, checking each element. If larger (than what's in previous position checked), leave it. If
 * smaller then march back down, shifting larger elements up until encounter a smaller element. Insert there.
 *
 * http://upload.wikimedia.org/wikipedia/commons/0/0f/Insertion-sort-example-300px.gif
 *
 * User: rpanjrath
 * Date: 8/20/13
 * Time: 2:55 PM
 */
public class InsertionSort {

    public int[] sort(int[] inputArray) {
        int arrayLength = inputArray.length;
        int temp;
        int j;
        for (int i = 1; i < arrayLength; i++) {
            temp = inputArray[i];
            j = i;
            // Keep on moving the element to the left of the list till its greater than current element in comparison.
            while (j > 0 && inputArray[j - 1] > temp) {
                inputArray[j] = inputArray[j - 1];
                j--;
            }
            inputArray[j] = temp;
        }
        return inputArray;
    }
}
