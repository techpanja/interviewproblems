package collections.nestedliststring;

import java.util.List;

/**
 * Input:---
 * List = ['a string', ['a','b','c'], 'spam', ['eggs']]
 *
 * Output:---
 * Foo.0:  a string
 * Foo.1.0: a
 * Foo.1.1 : b
 * Foo.1.2: c
 * Foo.2: spam
 * Foo.3.0: eggs
 *
 * http://www.programmerinterview.com/index.php/general-miscellaneous/nested-list-recursion/
 *
 * User: rpanjrath
 * Date: 10/16/13
 * Time: 11:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class NestedList {

    private static final String PERIOD = ".";
    private static final String COLON = ": ";

    private NestedList() {

    }

    public static void dumpList(String str, List inputList) {
        for (int i = 0; i < inputList.size(); i++) {
            if (inputList.get(i) instanceof List) {
                dumpList(str + PERIOD + i, (List) inputList.get(i));
            } else {
                System.out.println(str + PERIOD + i + COLON + inputList.get(i));
            }
        }
    }
}
