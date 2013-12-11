package arrays.test;

import arrays.allevennumberstoleft.*;

/**
 * Test class for All Evens to Left
 * User: rpanjrath
 * Date: 10/15/13
 * Time: 12:11 PM
 */
public class TestMoveAllEvensToLeft {

    public static void main(String[] args) {
        int[] inputArray = new int[] {1, 4, 5, 2, 6, 7, 3, 20};
        AllEvensToLeftandOddsToRight.moveAllEvensToLeft(inputArray);
    }
}
