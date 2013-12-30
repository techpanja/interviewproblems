package arrays.allevennumberstoleft;

/**
 * Given +ve numbers in an array. Put the even #s to the left of the array and
 * the odd to the right side of the array . Don't use extra array.
 * <p/>
 * User: rpanjrath
 * Date: 10/15/13
 * Time: 12:00 PM
 */
public class AllEvensToLeftandOddsToRight {

    private AllEvensToLeftandOddsToRight() {

    }

    public static void moveAllEvensToLeft(int[] inputArray) {
        System.out.println("Before moves:");
        for (int i : inputArray) {
            System.out.print(i + " ");
        }
        System.out.println();
        int currentPosition = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] % 2 == 0) {
                if (i != currentPosition) {
                    swap(inputArray, currentPosition, i);
                    currentPosition++;
                }
            }
        }
        System.out.println("After moves:");
        for (int i : inputArray) {
            System.out.print(i + " ");
        }
    }

    private static void swap(int[] inputArray, int currentPosition, int i) {
        int temp = inputArray[currentPosition];
        inputArray[currentPosition] = inputArray[i];
        inputArray[i] = temp;
    }
}
