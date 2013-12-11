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

    private static List outputList = new ArrayList();

//    public static List<ArrayList<String>> getPermutations(List<List<String>> lists) {
//        List<ArrayList<String>> perms = new ArrayList<ArrayList<String>>();
//        // generate new permutations one list at a time
//        for (List<String> list : lists) {
//            perms = generatePermutations(perms, list);
//        }
//        return perms;
//    }
//
//    private static List<ArrayList<String>> generatePermutations(List<ArrayList<String>> currentPermutations, List<String> list) {
//
//        // we'll be creating a whole new set of permutations from
//        // currentPermutations and the 'list' of new items
//        List<ArrayList<String>> newPermutations = new ArrayList<ArrayList<String>>();
//        for (String item : list) {
//            if (currentPermutations.isEmpty()) {
//                // first generated list - just add the single items
//                ArrayList<String> tempList = new ArrayList<String>();
//                tempList.add(item);
//                newPermutations.add(tempList);
//            } else {
//                // create a new permutation list based on the old list plus our new item
//                for (ArrayList<String> curList : currentPermutations) {
//                    if (!curList.contains(item)) {
//                        ArrayList<String> tempList = new ArrayList<String>(curList);
//                        tempList.add(item);
//                        newPermutations.add(tempList);
//                    }
//                }
//            }
//        }
//        return newPermutations;
//    }

    public static List<List> getCartesianOfLists(List<List> inputListOfLists) {
        List<List> permutations = new ArrayList<List>();
        for (List list : inputListOfLists) {
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

    //TODO
    public static List<List> getCartesianOfListsRecursion(List input) {
        getCartesianOfListsRecursion(input, new ArrayList(), new ArrayList<List>());
        return outputList;
    }

    private static void getCartesianOfListsRecursion(List inputList, List temp1, List<List> temp2) {
        List newOutput = new ArrayList();
        for (Object object : inputList) {
            if (object instanceof List) {
                getCartesianOfListsRecursion((List) object, temp1, temp2);
            } else {
                if (temp1.isEmpty()) {
                    List list = new ArrayList();
                    list.add(object);
                    temp2.add(list);
                } else {
                    for (List list : temp2) {
                        List innerList = new ArrayList();
                        innerList.addAll(list);
                        if (!innerList.contains(object)) {
                            innerList.add(object);
                            newOutput.add(innerList);
                        }
                    }
                }
            }
        }
        if (!newOutput.isEmpty()) {
            temp2 = new ArrayList<List>();
            temp2.addAll(newOutput);
            outputList.addAll(newOutput);
        }
        temp1.add("foo");
    }
}
