package arrays.maxsubarray;

/**
 * Test class for max sub array.
 * User: rpanjrath
 * Date: 11/4/13
 * Time: 4:44 PM
 */
public class TestMax {

    public static void main(String[] args) {
//        int[] inputArray = new int[]{2, -1, 2};
//        int[] inputArray = new int[]{-1, 4, 5, -2};
        int[] inputArray = new int[]{ 2 , 4, 22, 19, -48, -5 , 20, 40};
//        System.out.println(FindMaxSubArray.findMaxOfSubArrayUsingMathMax(inputArray));
        System.out.println(FindMaxSubArray.findMaxSubArrayUsingFor(inputArray));
    }
}
