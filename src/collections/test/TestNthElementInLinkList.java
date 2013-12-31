package collections.test;

import collections.findNTHlastelement.FindNthLastElement;

import java.util.LinkedList;

/**
 * Test class for find Nth element in link list.
 * User: rpanjrath
 * Date: 9/19/13
 * Time: 5:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestNthElementInLinkList {

    public static void main(String[] args) {
        FindNthLastElement nthLastElement = new FindNthLastElement();
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");
        linkedList.add("E");
        linkedList.add("F");
//        System.out.println(nthLastElement.findNthLastElement(linkedList, 4));
        for (int i = 0; i < 101; i++) {
            if (i % 2 == 0) {
                System.err.println(i);
            } else
                System.out.println(i);
        }
    }
}
