package sorting.algorithms;

/**
 * Choose a pivot value, Partition and Sort both parts. Recursive operation.
 * O(n log n)
 * <p/>
 * User: rpanjrath
 * Date: 8/20/13
 * Time: 2:55 PM
 */
public class QuickSort {

    private int[] inputArray;
    private int length;

    public int[] sort(int[] values) {
        // Check for empty or null array
        if (values == null || values.length == 0) {
            return values;
        }
        this.inputArray = values;
        length = values.length;
        quicksort(0, length - 1);
        return values;
    }

    private void quicksort(int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = inputArray[low + (high - low) / 2];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller then the pivot
            // element then get the next element from the left list.
			// If current value is greater than pivot value then stop!
            while (inputArray[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger then the pivot
            // element then get the next element (continue) from the right list.
			// If current value is less than pivot value then stop!
            while (inputArray[j] > pivot) {
                j--;
            }

            // If we have found a values in the left list which is larger then
            // the pivot element and if we have found a value in the right list
            // which is smaller then the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

    private void exchange(int i, int j) {
        int temp = inputArray[i];
        inputArray[i] = inputArray[j];
        inputArray[j] = temp;
    }
}
