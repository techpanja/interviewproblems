package arrays.numberwithhighestfreq;

/**
 * Given a sorted array of integers, write a function
 * that will return the number with the biggest number of repetitions.
 * 1 1 1 2 2 => 2
 *
 * O(n) solution.
 *
 * User: rahulpanjrath
 * Date: 1/3/14
 * Time: 9:54 PM
 */
public class FindNumberWithHighestFreq {

    private FindNumberWithHighestFreq() {

    }

    public static int numberWithHighestFrequency(int[] inputArray) {
        if (inputArray.length < 1) {
            System.out.println("Input array should contain atleast one element");
            return -1;
        }
        int globalCount = 0;
        int globalMaxFreqNumber = inputArray[0];
        int currentCount = 0;
        int currentNumber = inputArray[0];
        for (int i : inputArray) {
            if (i != currentNumber) {
                currentNumber = i;
                currentCount = 0;
            }
            currentCount++;
            if (currentCount > globalCount) {
                globalCount = currentCount;
                globalMaxFreqNumber = i;
            }
        }
        System.out.println(globalMaxFreqNumber);
        return globalMaxFreqNumber;
    }

    public static void main(String[] args) {
        numberWithHighestFrequency(new int[] {0, 0, 1, 2, 2, 2, 2});
    }

}
