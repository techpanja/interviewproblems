package maps.lrucache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Least Recently Used Cache Implementation.
 * User: rpanjrath
 * Date: 9/19/13
 * Time: 8:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class LRUCache extends LinkedHashMap {

    private int maxSize;

    public LRUCache(int maxSize) {
        super(maxSize, 0.75F, true);
        this.maxSize = maxSize;
    }

    public boolean removeEldestEntry(Map.Entry map) {
        return super.size() > maxSize;
    }
}
