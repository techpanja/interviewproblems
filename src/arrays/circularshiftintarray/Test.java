package arrays.circularshiftintarray;

/**
 * Test
 * User: rpanjrath
 * Date: 11/11/13
 * Time: 5:39 PM
 */
public class Test {

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 4, 5, 6};

        CircularShiftArray.circularShiftToRight(input, 13);
        CircularShiftArray.circularShiftToLeft(input, 10);

        CircularShiftArray.circularShiftToRightInPlace(input, 8);
        CircularShiftArray.circularShiftToLeftInPlace(input, 4);
    }
}
