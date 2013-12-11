package collections.test;

import collections.nestedlistsum.NestedListSum;

import java.util.ArrayList;
import java.util.List;

/**
 * Test class for nested list sum.
 * User: rpanjrath
 * Date: 10/7/13
 * Time: 4:20 PM
 */
public class TestNestedListSum {

    public static void main(String[] args) {
        List parentList = new ArrayList();
        List childList1 = new ArrayList();
        childList1.add(2);
        childList1.add(3);
        parentList.add(2);
        List childList11 = new ArrayList();
        childList11.add(1);
        childList1.add(childList11);
        parentList.add(childList1);
        parentList.add(5);
        System.out.println(NestedListSum.findNestedListSum(parentList));
    }
}
