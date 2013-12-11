package arrays.findduplicatecountsortedarray;

/**
 * Duplicates count in sorted array.
 * E.g. 1 2 3 3 4 5 6 6 6 7 19
 * for x = 3, count = 2
 * for x = 6, count = 3
 * <p/>
 * Logic:
 * --------To find first Occurrence:--------
 * Condition for binary search to find first occurrence is as follows:
 * <p/>
 * Return the position if any one of the following is true:
 * mid == 0 and a[mid] == K
 * a[mid] == K and a[mid-1] < K
 * <p/>
 * ------To find last Occurrence:--------
 * Condition for binary search to find last occurrence is as follows:
 * <p/>
 * Return the position if any one of the following is true:
 * mid == n and a[mid] == K where n is lenght of the array – 1
 * a[mid] == K and a[mid+1] > K
 * <p/>
 * ----------------Total Occurence----------------------
 * Total number of occurrences =  lastOccurrence – firstOccurrence + 1
 * <p/>
 * http://crackinterviewtoday.wordpress.com/2010/03/05/count-the-number-of-occurrences-of-a-element-in-a-sorted-array/
 * <p/>
 * User: rpanjrath
 * Date: 12/10/13
 * Time: 4:55 PM
 */
public class DuplicatesCountInSortedArray {

    public static int findDuplicateCount(int[] inputSortedArray, int number) {
        int low = 0;
        int high = inputSortedArray.length - 1;
        int firstOccurence = findFirstOccurence(inputSortedArray, low, high, number);
        int lastOccurence = findLastOccurence(inputSortedArray, low, high, number);
        System.out.println("First Occurence at position: " + firstOccurence);
        System.out.println("Last Occurence at position: " + lastOccurence);
        if (lastOccurence == -1 && firstOccurence == -1) {
            return 0;
        }
        if (lastOccurence == firstOccurence) {
            return 1;
        }
        return lastOccurence - firstOccurence + 1;
    }

    private static int findFirstOccurence(int[] inputSortedArray, int low, int high, int number) {
        if (high >= low) {
            int mid = (low + high) / 2;
            if ((inputSortedArray[mid] == number && mid == 0)
                    || (inputSortedArray[mid] == number && inputSortedArray[mid - 1] < number)) {
                return mid;
            } else if (inputSortedArray[mid] >= number) {
                return findFirstOccurence(inputSortedArray, low, mid - 1, number);
            } else {
                return findFirstOccurence(inputSortedArray, mid + 1, high, number);
            }
        }
        return -1;
    }

    private static int findLastOccurence(int[] inputSortedArray, int low, int high, int number) {
        if (high >= low) {
            int mid = (low + high) / 2;
            if ((inputSortedArray[mid] == number && mid == inputSortedArray.length - 1)
                    || (inputSortedArray[mid] == number && inputSortedArray[mid + 1] > number)) {
                return mid;
            } else if (inputSortedArray[mid] <= number) {
                return findLastOccurence(inputSortedArray, mid + 1, high, number);
            } else {
                return findLastOccurence(inputSortedArray, low, mid - 1, number);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int count = findDuplicateCount(new int[]{2, 2, 2, 3, 4, 8, 11, 11, 12, 13, 13, 13, 13, 15}, 11);
        System.out.println(count);
    }
}
