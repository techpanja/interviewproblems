package collections.cartesianproblem;

import java.util.ArrayList;
import java.util.List;

/**
 * Find cartesian of Lists of lists.
 * User: rpanjrath
 * Date: 10/17/13
 * Time: 1:48 PM
 */
public class CartesianOfLists {

    public static List<List> getCartesianOfLists(List<List<String>> inputListOfLists) {
        List<List> permutations = new ArrayList<List>();
        for (List<String> list : inputListOfLists) {
            permutations = generatePermutations(permutations, list);
        }
        return permutations;
    }

    private static List<List> generatePermutations(List<List> permutations, List<String> list) {
        List<List> newPermutations = new ArrayList<List>();
        for (String str : list) {
            if (permutations.isEmpty()) {
                List tempList = new ArrayList();
                tempList.add(str);
                newPermutations.add(tempList);
            } else {
                for (List tempList : permutations) {
                    List innerList = new ArrayList();
                    innerList.addAll(tempList);
                    if (!innerList.contains(str)) {
                        innerList.add(str);
                        newPermutations.add(innerList);
                    }
                }
            }
        }
        return newPermutations;
    }
}