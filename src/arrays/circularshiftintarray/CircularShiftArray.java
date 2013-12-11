package arrays.circularshiftintarray;

/**
 * Shift array of integers circularly given input array and shift size.
 * O(N) time and space complexity.
 * User: rpanjrath
 * Date: 11/11/13
 * Time: 5:30 PM
 */
public class CircularShiftArray {

    private CircularShiftArray() {

    }

    public static void circularShiftToRight(int[] inputArray, int shiftSize) {
        if (inputArray.length <= 1) {
            System.out.println("Array must have more than one integer.");

        } else {
            System.out.println("Before shift:--");
            for (int temp : inputArray) {
                System.out.println(temp);
            }
            int i = 0;
            int[] outputArray = new int[inputArray.length];
            while (i < inputArray.length) {
                int k = (shiftSize + i) % inputArray.length;
                outputArray[k] = inputArray[i];
                i++;
            }
            System.out.println("After shift:--");
            for (int temp : outputArray) {
                System.out.println(temp);
            }
        }
    }

    public static void circularShiftToRightInPlace(int[] inputArray, int shiftSize) {
        int length = inputArray.length;
        if (inputArray.length <= 1) {
            System.out.println("Array must have more than one integer.");

        } else {
            System.out.println("Before shift:--");
            for (int temp : inputArray) {
                System.out.println(temp);
            }
            int start = 0;
            int end = length - (shiftSize % length) - 1;
            circularShiftToRightInPlace(inputArray, start, end);
            circularShiftToRightInPlace(inputArray, end + 1, inputArray.length - 1);
            circularShiftToRightInPlace(inputArray, 0, inputArray.length - 1);
            System.out.println("After shift:--");
            for (int temp : inputArray) {
                System.out.println(temp);
            }
        }
    }

    private static void circularShiftToRightInPlace(int[] inputArray, int start, int end) {
        int i = start;
        int j = end;
        while (i < j) {
            int temp = inputArray[i];
            inputArray[i] = inputArray[j];
            inputArray[j] = temp;
            i++;
            j--;
        }
    }
}
