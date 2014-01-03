package arrays.maxsubarray;

import java.util.Arrays;

/**
 * the task of finding the contiguous subarray which has the largest sum.
 *
 * Algo:----
 *
 * 1. Maintain two variables: maxSoFar and maxEndingAtCurrentPosition in Array.
 * 2. Update maxEndingAtCurrentPosition if (maxEndingAtCurrentPosition + current[i]) > than 0.
 * 3. Keep on updating maxSoFar whenever maxEndingAtCurrentPosition is greater than maxSoFar.
 *
 * http://en.wikipedia.org/wiki/Kadane%27s_Algorithm
 * User: rpanjrath
 * Date: 11/4/13
 * Time: 3:23 PM
 */
public class FindMaxSubArray {

    private FindMaxSubArray() {

    }

    public static int findMaxOfSubArrayUsingMathMax(int[] inputArray) {
        int maxSoFar = 0;
        int maxEndingHere = 0;
        for (int i : inputArray) {
            maxEndingHere = Math.max(0, maxEndingHere + i);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public static String findMaxSubArrayUsingFor(int[] inputArray) {
        int maxSoFar = 0;
        int maxEndingHere = 0;
        int maxStartIndex = 0;
        int maxEndIndex = 0;
        for (int i = 0; i < inputArray.length; i++) {
            System.out.println("ending here " + maxEndingHere);
            System.out.println("so far " + maxSoFar);
            if (maxEndingHere + inputArray[i] > 0) {
                maxEndingHere = maxEndingHere + inputArray[i];
            } else {
                maxEndingHere = 0;
                maxStartIndex = i + 1;
            }
            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
                maxEndIndex = i;
            }
        }
        int[] maxArray = new int[0];
        if (maxStartIndex <= maxEndIndex) {
            maxArray = Arrays.copyOfRange(inputArray, maxStartIndex, maxEndIndex + 1);
        }
        return String.valueOf("\nInput-Array:" + Arrays.toString(inputArray)
                + "\nMax: " + maxSoFar
                + "\nSub-Array:" + Arrays.toString(maxArray));
    }
}
