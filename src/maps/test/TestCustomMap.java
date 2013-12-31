package maps.test;

import maps.customhashmap.CustomHashMap;
import maps.customhashmap.CustomHashMapImpl;

/**
 * Testing custom map.
 * User: rpanjrath
 * Date: 9/22/13
 * Time: 2:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestCustomMap {

    public static void main(String[] args) {
        CustomHashMap customHashMap = new CustomHashMapImpl(5);
        customHashMap.put(1, "abc");
        customHashMap.put(2, "def");
        customHashMap.put(5, "aaa");
        // will update value for key 5
        customHashMap.put(5, "a33a");
        // Will result in collision because acc. to hashcode function key.hashCode() % size of hashmap
        // 1 % 5 = 1 and 6 % 5 = 1
        customHashMap.put(6, "kji");
//        customHashMap.get(5);
        System.out.println(customHashMap.get(1));
        System.out.println(customHashMap.get(5));
        System.out.println(customHashMap.get(6));
    }
}
