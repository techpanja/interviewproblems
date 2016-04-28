package collections.nestedlistsum;

import java.util.List;

/**
 * Given a nested list of integers, returns the sum of all integers in the list weighted by their depth
 * For example, given the list {{1,1},2,{1,1}} the function should return 10 (four 1's at depth 2, one 2 at depth 1)
 * Given the list {1,{4,{6}}} the function should return 27 (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3)
 * User: rpanjrath
 * Date: 10/7/13
 * Time: 4:13 PM
 */
public class NestedListSum {

    private NestedListSum() {

    }

    public static int findNestedListSum(List nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            System.out.println("Input cannot be empty or null");
            return 0;
        }
        return findNestedListSum(nestedList, 1);
    }

    private static int findNestedListSum(List inputList, int depth) {
        int sum = 0;
        for (Object anInputList : inputList) {
            if (anInputList instanceof List) {
                sum = sum + findNestedListSum((List) anInputList, depth + 1);
            } else {
                sum = sum + depth * (Integer) anInputList;
                System.out.println("integer => " + anInputList + " Depth => " + depth);
            }
        }
        return sum;
    }
}
