package arrays.findpairsequaltosum;

import java.util.ArrayList;
import java.util.List;

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
                list.add(pair);
            }
        }
        return list;
    }

//    public static List<String> findAllEqualToSum(int[] inputArray, int sum) {
//        inputSum = sum;
//        int currentIndex = 0;
//        List<String> outputList = new ArrayList<String>();
//        List<Integer> inputList = new LinkedList<Integer>();
//        for (int i : inputArray) {
//            inputList.add(i);
//        }
//        for (Integer currentInteger : inputList) {
//            findAllEqualToSum(currentIndex, inputList, "", currentInteger, outputList);
//
//        }
//        return outputList;
//    }
//
//    private static void findAllEqualToSum(int currentIndex, List<Integer> inputArray, String inputString, int counter, List<String> outputList) {
//        if (currentIndex == inputArray.size()) {
//            return;
//        }
//        counter = counter + inputArray.get(currentIndex);
//        inputString = inputString.concat(String.valueOf(inputArray.get(currentIndex))).concat(",");
//        if (counter == inputSum) {
//            outputList.add(inputString);
//        }
//        currentIndex++;
//        findAllEqualToSum(currentIndex, inputArray, inputString, counter, outputList);
//    }

//    static void sum_up_recursive(ArrayList<Integer> numbers, int target, ArrayList<Integer> partial) {
//        int s = 0;
//        for (int x : partial) s += x;
//        if (s == target)
//            System.out.println("sum(" + Arrays.toString(partial.toArray()) + ")=" + target);
//        if (s >= target)
//            return;
//        for (int i = 0; i < numbers.size(); i++) {
//            ArrayList<Integer> remaining = new ArrayList<Integer>();
//            int n = numbers.get(i);
//            for (int j = i + 1; j < numbers.size(); j++) remaining.add(numbers.get(j));
//            ArrayList<Integer> partial_rec = new ArrayList<Integer>(partial);
//            partial_rec.add(n);
//            sum_up_recursive(remaining, target, partial_rec);
//        }
//    }
//
//    static void sum_up(ArrayList<Integer> numbers, int target) {
//        sum_up_recursive(numbers, target, new ArrayList<Integer>());
//    }
//
//    public static void main(String args[]) {
//        Integer[] numbers = {3, 9, 8, 4, 5, 7, 10, 2};
//        int target = 15;
//        sum_up(new ArrayList<Integer>(Arrays.asList(numbers)), target);
//    }

}
