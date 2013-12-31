package maps.customhashmap;

/**
 * Implement own hashmap.
 * User: rpanjrath
 * Date: 9/22/13
 * Time: 1:12 PM
 * To change this template use File | Settings | File Templates.
 */
public interface CustomHashMap<K, V> {

    void put(K key, V value);

    V get(K key);

    boolean remove(K key);
}
