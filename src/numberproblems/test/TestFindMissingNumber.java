package numberproblems.test;

import numberproblems.findmissingnumber.FindMissingNumber;

/**
 * Test Class
 * User: rpanjrath
 * Date: 10/28/13
 * Time: 12:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestFindMissingNumber {

    public static void main(String[] args) {
        int[] inputArray = new int[] {3, 2, 4, 5, 6, 7, 8};
        int missing = FindMissingNumber.findMissingNumberUsingFormula(inputArray);
        System.out.println(missing);
    }
}
