package objects.immutableclass;

import java.util.ArrayList;
import java.util.List;

/**
 * Test class for ImmutableClass
 * User: rpanjrath
 * Date: 10/22/13
 * Time: 4:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestImmutability {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("abc");
        ImmutableClass immutableClass = new ImmutableClass(5, "r", list);
        List<String> list1 = immutableClass.getList();
        list1.add("def");
        List<String> list2 = immutableClass.getList();
        System.out.println("List 1: ");
        for (String str : list1) {
            System.out.print(str + " ");
        }
        System.out.println();
        System.out.println("List 2: ");
        for (String str : list2) {
            System.out.print(str + " ");
        }
    }
}
