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
        System.out.println();
        System.out.println("Before moves:");
        for (int input : inputArray) {
            System.out.print(input + " ");
        }
        System.out.println();
        int i = 0;
        int j = inputArray.length - 1;
        while (i < j) {
            while (inputArray[i] % 2 == 0) {
                i++;
            }
            while (inputArray[j] % 2 != 0) {
                j--;
            }
            if (i < j)
                swap(inputArray, i, j);
        }
        System.out.println("After moves:");
        for (int input : inputArray) {
            System.out.print(input + " ");
        }
    }

    private static void swap(int[] inputArray, int currentPosition, int i) {
        int temp = inputArray[currentPosition];
        inputArray[currentPosition] = inputArray[i];
        inputArray[i] = temp;
    }

    public static void main(String[] args) {
        moveAllEvensToLeft(new int[]{1, 4, 3, 4,3, 4, 1, 4, 1, 3, 5, 6});
        moveAllEvensToLeft(new int[]{1, 4, 4, 6});
        moveAllEvensToLeft(new int[]{4, 4, 6, 1});
        moveAllEvensToLeft(new int[]{4, 3, 4, 6, 1});
        moveAllEvensToLeft(new int[]{1, 3, 4});
        moveAllEvensToLeft(new int[]{1, 4});
    }
}
