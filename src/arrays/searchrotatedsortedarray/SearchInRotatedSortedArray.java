package arrays.searchrotatedsortedarray;

/**
 * Search for a number in rotated sorted array (ascending or descending). for e.g. 8 9 1 2 3 4 5 6 7
 * Created by techpanja
 * Created on 1/27/14 11:53 AM.
 */
public class SearchInRotatedSortedArray {

    private SearchInRotatedSortedArray() {

    }

    public static boolean searchInRotatedSortedArray(int[] inputArray, int number) {
        if (inputArray.length == 0) {
            return false;
        }
        if (inputArray.length == 1) {
            return inputArray[0] == number;
        }
        int low = 0, high = inputArray.length - 1;
        return recursiveSearchAscendingOrder(inputArray, low, high, number)
                || recursiveSearchDescendingOrder(inputArray, low, high, number);
    }

    private static boolean recursiveSearchAscendingOrder(int[] inputArray, int low, int high, int number) {
        if (high < low) {
            return false;
        }
        int mid = (low + high) / 2;
        if (inputArray[low] == number
                || inputArray[mid] == number
                || inputArray[high] == number) {
            return true;
        }
        if (inputArray[low] < inputArray[mid]
                && inputArray[low] < number
                && number <= inputArray[mid]) {
            return recursiveSearchAscendingOrder(inputArray, low, mid - 1, number);
        } else if (inputArray[mid] < inputArray[high]
                && inputArray[mid] < number
                && number <= inputArray[high]) {
            return recursiveSearchAscendingOrder(inputArray, mid + 1, high, number);
        } else if (inputArray[low] > inputArray[mid]) {
            return recursiveSearchAscendingOrder(inputArray, low, mid - 1, number);
        } else if (inputArray[mid] > inputArray[high]) {
            return recursiveSearchAscendingOrder(inputArray, mid + 1, high, number);
        } else {
            return false;
        }
    }

    private static boolean recursiveSearchDescendingOrder(int[] inputArray, int low, int high, int number) {
        if (high < low) {
            return false;
        }
        int mid = (low + high) / 2;
        if (inputArray[low] == number
                || inputArray[mid] == number
                || inputArray[high] == number) {
            return true;
        }
        if (inputArray[low] > inputArray[mid]
                && inputArray[low] > number
                && number >= inputArray[mid]) {
            return recursiveSearchDescendingOrder(inputArray, low, mid - 1, number);
        } else if (inputArray[mid] > inputArray[high]
                && inputArray[mid] > number
                && number >= inputArray[high]) {
            return recursiveSearchDescendingOrder(inputArray, mid + 1, high, number);
        } else if (inputArray[low] < inputArray[mid]) {
            return recursiveSearchDescendingOrder(inputArray, low, mid - 1, number);
        } else if (inputArray[mid] < inputArray[high]) {
            return recursiveSearchDescendingOrder(inputArray, mid + 1, high, number);
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        System.out.println(searchInRotatedSortedArray(new int[]{8, 9, 10, 1, 2, 3, 4, 5, 6, 7}, 24));
        System.out.println(searchInRotatedSortedArray(new int[]{3, 2, 1, 6, 5, 4}, 41));
        System.out.println(searchInRotatedSortedArray(new int[]{3, 2, 1, 6, 5, 4}, 5));
        System.out.println(searchInRotatedSortedArray(new int[]{4, 5, 6, 1, 2, 3, 4}, 6));
    }
}
