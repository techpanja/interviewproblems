package collections.test;

import collections.cartesianproblem.CartesianOfLists;

import java.util.ArrayList;
import java.util.List;

/**
 * Test class for Cartesian of Lists of lists.
 * User: rpanjrath
 * Date: 10/17/13
 * Time: 1:53 PM
 */
public class TestCartesianOfLists {

    public static void main(String args[]) {
        List<String> childList1 = new ArrayList<String>();
        childList1.add("a");
        childList1.add("b");
        List<String> childList2 = new ArrayList<String>();
        childList2.add("d");
        childList2.add("e");
//        childList2.add("e");
        List<String> childList3 = new ArrayList<String>();
        childList3.add("f");
        childList3.add("g");
        childList3.add("h");
        List<List<String>> parentList = new ArrayList<List<String>>();
        parentList.add(childList1);
        parentList.add(childList2);
        parentList.add(childList3);
//        List<List> output = CartesianOfLists.getCartesianOfLists(parentList);
        List<List> output = CartesianOfLists.getCartesianOfLists(parentList);
        for (List<String> list : output) {
            for (String str : list) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }
}
