package arrays.findpairsequaltosum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Write a program takes array input{1,0,2,3} and num =3.and
 * provides output {1,2}{0,3}{2,1}{3,0} sum equals the num.
 * <p/>
 * Logic: x + y = 3. You can consider each element in input as x and check if remaining array contains y since
 * y = 3 - x. For e.g. x = 1 then y = 3 - 1 = 2. Check if remaining array {0, 2, 3} contains 2.... form a pair if yes.
 * User: rpanjrath
 * Date: 10/8/13
 * Time: 2:46 PM
 */
public class FindPairsEqualToSum {

    private static int inputSum = 0;

    /*
    * O(N power of 2) solution with O(1) space.
    * */
    public static List<String> findPairsForSum(int[] inputArray, int sum) {
        List<String> list = new ArrayList<String>();
        List<Integer> inputList = new ArrayList<Integer>();
        for (int i : inputArray) {
            inputList.add(i);
        }
        for (int i : inputArray) {
            int tempInt = sum - i;
            if (inputList.contains(tempInt)) {
                String pair = String.valueOf(i + ", " + tempInt);
                System.out.print(i + ":" + tempInt + " , ");
                list.add(pair);
            }
        }
        return list;
    }

    /*
    * O(N) solution using additional space (map).
    * */
    public static List<String> findPairsForSumUsingMap(int[] inputArray, int sum) {
        List<String> output = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int value : inputArray) {
            if (map.get(value) == null) {
                map.put(sum - value, value);
            } else {
                output.add(String.valueOf(map.get(value) + ',' + value) + "  :  ");
                System.out.print(String.valueOf(map.get(value)) + ":" + value + " , ");
            }
        }
        return output;
    }

    public static void main(String args[]) {
        findPairsForSumUsingMap(new int[]{2, 4, 0, 1, -2}, 2);
        findPairsForSum(new int[]{2, 4, 0, 1, -2}, 2);
    }
}
