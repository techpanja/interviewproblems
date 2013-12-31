package maps.test;

import maps.lrucache.LRUCache;

/**
 * User: rpanjrath
 * Date: 9/19/13
 * Time: 8:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestLRUCache {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, "abc");
        lruCache.put(2, "def");
        System.out.println(lruCache.values().toString());
        lruCache.put(3, "ghi");
        System.out.println(lruCache.values().toString());
        lruCache.put(4, "jkl");
        System.out.println(lruCache.values().toString());
    }
}
