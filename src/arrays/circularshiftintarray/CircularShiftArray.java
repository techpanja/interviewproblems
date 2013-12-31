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
            System.out.println("\nBefore shift:--");
            for (int temp : inputArray) {
                System.out.print(temp + " ");
            }
            int i = 0;
            int[] outputArray = new int[inputArray.length];
            while (i < inputArray.length) {
                int k = (i + shiftSize) % inputArray.length;
                outputArray[k] = inputArray[i];
                i++;
            }
            System.out.println("\nAfter shift:--");
            for (int temp : outputArray) {
                System.out.print(temp + " ");
            }
        }
    }

    public static void circularShiftToLeft(int[] inputArray, int shiftSize) {
        if (inputArray.length <= 1) {
            System.out.println("Array must have more than one integer.");

        } else {
            System.out.println("\nBefore shift:--");
            for (int temp : inputArray) {
                System.out.print(temp + " ");
            }
            int i = 0;
            shiftSize = shiftSize % inputArray.length;
            int[] outputArray = new int[inputArray.length];
            while (i < inputArray.length) {
                int k = i - shiftSize;
                if (k < 0) {
                    k = k + inputArray.length;
                }
                outputArray[k] = inputArray[i];
                i++;
            }
            System.out.println("\nAfter shift:--");
            for (int temp : outputArray) {
                System.out.print(temp + " ");
            }
        }
    }

    public static void circularShiftToRightInPlace(int[] inputArray, int shiftSize) {
        int length = inputArray.length;
        if (inputArray.length <= 1) {
            System.out.println("Array must have more than one integer.");

        } else {
            System.out.println("\nBefore shift:--");
            for (int temp : inputArray) {
                System.out.print(temp + " ");
            }
            int start = 0;
            int end = length - (shiftSize % length) - 1;
            swap(inputArray, start, end);
            swap(inputArray, end + 1, inputArray.length - 1);
            swap(inputArray, 0, inputArray.length - 1);
            System.out.println("\nAfter shift:--");
            for (int temp : inputArray) {
                System.out.print(temp + " ");
            }
        }
    }

    public static void circularShiftToLeftInPlace(int[] inputArray, int shiftSize) {
        int length = inputArray.length;
        if (inputArray.length <= 1) {
            System.out.println("Array must have more than one integer.");

        } else {
            System.out.println("\nBefore shift:--");
            for (int temp : inputArray) {
                System.out.print(temp + " ");
            }
            int start = 0;
            int end = length - (shiftSize % length) - 1;
            swap(inputArray, 0, inputArray.length - 1);
            swap(inputArray, start, end);
            swap(inputArray, end + 1, inputArray.length - 1);
            System.out.println("\nAfter shift:--");
            for (int temp : inputArray) {
                System.out.print(temp + " ");
            }
        }
    }

    private static void swap(int[] inputArray, int start, int end) {
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
