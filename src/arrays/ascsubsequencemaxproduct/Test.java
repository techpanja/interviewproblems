package arrays.ascsubsequencemaxproduct;

import java.util.Arrays;

/**
 * Test clas
 * User: rpanjrath
 * Date: 11/14/13
 * Time: 3:20 PM
 */
public class Test {

    public static void main(String[] args) {
//        int[] ints = new int[] {6, 7, 8, 1, 2, 3, 9, 10};
//        int[] ints = new int[] {4, 7, 9, 8, 2};
//        int[] ints = new int[] {1, 11, 12, 7, 8, 9};
//        int[] ints = new int[] {1, 4, 2, 3};
//        int[] ints = new int[]{1, 11, 8, 9, 10, 14};
//        int[] ints = new int[]{10, 6, 11};
        int[] ints = new int[]{1, 5, 10, 8, 9};
        System.out.println(Arrays.toString(SubsequenceProduct.findSubsequenceWithMaxProduct(ints)));
    }
}
