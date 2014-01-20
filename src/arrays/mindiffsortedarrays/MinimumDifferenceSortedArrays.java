package arrays.mindiffsortedarrays;

/**
 * Given two sorted (ascending) arrays of integers, where the integers do not repeat and the two arrays have no common integers.
 * Let x be any integer in the first array, y any integer in the second. Find min(Abs(x-y)). That is, find the smallest
 * difference between any of the integers in the two arrays.
 * <p/>
 * Created by techpanja
 * Created on 1/20/14 3:00 PM.
 */
public class MinimumDifferenceSortedArrays {

    private MinimumDifferenceSortedArrays() {

    }

    /*
    * Dynamic approach. O(N^2).
    * */
    public static int findMinDifference(int[] inputArrayX, int[] inputArrayY) {
        if (inputArrayX.length == 0 || inputArrayY.length == 0) {
            return -1;
        }
        int minDifference = Math.abs(inputArrayX[0] - inputArrayY[0]);
        for (int x : inputArrayX) {
            for (int y : inputArrayY) {
                if (Math.abs(x - y) < minDifference) {
                    minDifference = Math.abs(x - y);
                }
            }
        }
        return minDifference;
    }

    /*
    * Using while loop. O(x + y) solution.
    * */
    public static int findMinDifferenceUsingWhile(int[] inputArrayX, int[] inputArrayY) {
        if (inputArrayX.length == 0 || inputArrayY.length == 0) {
            return -1;
        }
        int minDifference = Math.abs(inputArrayX[0] - inputArrayY[0]);
        int i = 0, j = 0;
        while (i < inputArrayX.length && j < inputArrayY.length) {
            minDifference = Math.min(minDifference, Math.abs(inputArrayX[i] - inputArrayY[j]));
            if (inputArrayX[i] < inputArrayY[j]) {
                i++;
            } else {
                j++;
            }

        }
        return minDifference;
    }

    public static void main(String[] args) {
        int[] inputArrayX = new int[]{-1, 4, 6};
        int[] inputArrayY = new int[]{22, 26, 40};
        System.out.println(findMinDifference(inputArrayX, inputArrayY));
        System.out.println(findMinDifferenceUsingWhile(inputArrayX, inputArrayY));

        int[] inputArrayI = new int[]{-1, 4, 46};
        int[] inputArrayJ = new int[]{22, 26, 40};
        System.out.println(findMinDifference(inputArrayI, inputArrayJ));
        System.out.println(findMinDifferenceUsingWhile(inputArrayI, inputArrayJ));

        int[] inputArrayA = new int[]{1, 4, 6};
        int[] inputArrayB = new int[]{2, 9, 13};
        System.out.println(findMinDifference(inputArrayA, inputArrayB));
        System.out.println(findMinDifferenceUsingWhile(inputArrayA, inputArrayB));
    }
}
