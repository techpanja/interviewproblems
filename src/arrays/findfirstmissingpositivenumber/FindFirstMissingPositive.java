package arrays.findfirstmissingpositivenumber;

/**
 * Description: Find first missing positive number in an un-sorted array.
 * E.g. [0, 2, 1, 4] ==> 3
 * E.g. [4, -1, 0, 2] ==> 1
 * E.g. [1, 2, 0, 3] ==> 4
 * Author: techpanja
 * Date: 4/14/16 5:23 PM.
 */
public class FindFirstMissingPositive {

    /**
     * The straight-forward O(n log n) + O(n) solution would be sort the array and iterate the sorted array.
     * A better linear solution is being used here. Idea is to iterate the array and at each iteration put a[i]
     * at position i, if i < a.length and i >= 0.
     */
    public static int findFirstMissingPositiveNumber(int[] inputArr) {
        for (int i = 0; i < inputArr.length; i++) {
            int currentValue = inputArr[i];
            if (currentValue < inputArr.length && currentValue >= 0) {
                int temp = inputArr[i];
                inputArr[i] = inputArr[currentValue];
                inputArr[currentValue] = temp;
            }
        }
        for (int i = 0; i < inputArr.length; i++) {
            if (inputArr[i] != i) {
                return i;
            }
        }
        return inputArr.length;
    }

    public static void main(String[] args) {
        System.out.println(findFirstMissingPositiveNumber(new int[]{1, 2, 0, 3}));
    }
}
