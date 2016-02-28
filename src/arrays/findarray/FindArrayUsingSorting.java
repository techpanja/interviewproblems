package arrays.findarray;

import java.util.Arrays;

/**
 * Description: Find Array using sorting.
 * Author: Rahul Panjrath
 * Date: 2/28/16 1:31 PM.
 */
public class FindArrayUsingSorting implements FindArray {

    /*
    * O(mLogm + nLogn) m -> outer array; n -> sub-array.
    * */
    @Override
    public int findArray(int[] array, int[] subArray) {
        return findArray(array, subArray, array.length, subArray.length);
    }

    private int findArray(int[] outerArray, int[] subArray, int outerArrayLength, int subArrayLength) {
        int i = 0, j = 0;
        if (outerArrayLength < subArrayLength) {
            return 0;
        }
        Arrays.sort(outerArray);
        Arrays.sort(subArray);
        while (i < subArrayLength && j < outerArrayLength) {
            if (outerArray[j] < subArray[i]) {
                j++;
            } else if (outerArray[j] == subArray[i]) {
                j++;
                i++;
            } else if (outerArray[j] > subArray[i]) {
                return 0;
            }
        }

        if (i < subArrayLength) {
            return 0;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        FindArray findArray = new FindArrayUsingSorting();
        System.out.println(findArray.findArray(new int[]{7, 8, 9, 11, 8, 9, 1, 10}, new int[]{8, 9, 12}));
        System.out.println(findArray.findArray(new int[]{7, 8, 9, 11, 8, 9, 10}, new int[]{8, 9, 10}));
        System.out.println(findArray.findArray(new int[]{7, 8, 9, 11, 8, 9, 8, 9, 10}, new int[]{8, 9, 10}));
    }
}
