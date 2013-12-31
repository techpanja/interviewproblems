package collections.test;

import collections.nestedliststring.NestedList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: rpanjrath
 * Date: 10/16/13
 * Time: 11:31 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestNestedList {
    public static void main(String[] args) {

        List childList1 = new ArrayList();
        childList1.add("a");
        childList1.add("b");
        childList1.add("c");
        List childList2 = new ArrayList();
        childList2.add("world");

        List inputList = new ArrayList();
        inputList.add("Snow Patrol");
        inputList.add(childList1);
        inputList.add("hello");
        inputList.add(childList2);

        NestedList.dumpList("Foo", inputList);
    }
}
