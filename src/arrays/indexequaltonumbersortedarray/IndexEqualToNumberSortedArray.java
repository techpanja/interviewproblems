package arrays.indexequaltonumbersortedarray;

/**
 * Given a sorted array (ascending order and distinct elements), find i such that inputArr[i] = i. Return -1 if
 * nothing found.
 * <p/>
 * 0 3 5 6 7
 * 0 1 2 3 4
 * Created by techpanja
 * Created on 2/3/14 3:34 PM.
 */
public class IndexEqualToNumberSortedArray {

    private IndexEqualToNumberSortedArray() {

    }

    /*
    * Binary search. O(log N) solution.
    * */
    public static int indexEqualToNumberSortedArray(int[] inputArray) {
        if (inputArray.length == 0) {
            return -1;
        }
        int low = 0;
        int high = inputArray.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (inputArray[mid] == mid) {
                return mid;
            } else if (inputArray[mid] > mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(indexEqualToNumberSortedArray(new int[] {1, 2, 4, 5, 6, 7}));
        System.out.println(indexEqualToNumberSortedArray(new int[] {0, 3, 4, 5, 6, 7}));
        System.out.println(indexEqualToNumberSortedArray(new int[] {-1, 0, 1, 2, 4, 7}));
        System.out.println(indexEqualToNumberSortedArray(new int[] {-1, 0, 1, 2, 3, 5}));
        System.out.println(indexEqualToNumberSortedArray(new int[] {-1, 0, 1, 3, 5, 6}));
    }
}
