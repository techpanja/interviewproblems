package arrays.dutchflagproblem;

/**
 * Description: Given random 0s, 1s and 2s in an array, re-arrange them such as all 0s are together, 1s are together
 * and 2s are together in O(n) time and O(1) space.
 * Hint: Dutch-Flag Problem
 * Author: Rahul Panjrath
 * Date: 4/27/16 5:53 PM.
 */
public class RearrangeZeroesOnesTwos {

    private static void rearrange(int[] inputArray) {
        int low = 0, mid = 0, high = inputArray.length - 1;
        while (mid <= high) {
            if (inputArray[mid] == 0) {
                swap(inputArray, mid, low);
                low++;
                mid++;
            } else if (inputArray[mid] == 1) {
                mid++;
            } else {
                swap(inputArray, mid, high);
                high--;
            }
        }
        for (int value : inputArray) {
            System.out.print(value + " ");
        }
    }

    private static void swap(int[] inputArray, int i, int j) {
        int temp = inputArray[i];
        inputArray[i] = inputArray[j];
        inputArray[j] = temp;
    }

    public static void main(String[] args) {
//           rearrange(new int[]{2, 0, 1 , 2});
//           rearrange(new int[]{0, 0, 1 , 2});
//           rearrange(new int[]{1, 0, 1 , 2});
//           rearrange(new int[]{1, 1, 1 , 2, 0});
//           rearrange(new int[]{0, 1, 1, 1 , 2, 0});
//           rearrange(new int[]{2, 0, 1});
//        rearrange(new int[]{2, 1, 0});
        rearrange(new int[]{0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1});
    }
}



