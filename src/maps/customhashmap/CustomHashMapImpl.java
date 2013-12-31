package maps.customhashmap;

/**
 * Implementing hashmap.
 * User: rpanjrath
 * Date: 9/22/13
 * Time: 1:17 PM
 */
public class CustomHashMapImpl<K, V> implements CustomHashMap<K, V> {

    private int DEFAULT_BUCKET_COUNT = 10;
    Entry[] entryBuckets;

    public CustomHashMapImpl() {
        this.entryBuckets = new Entry[DEFAULT_BUCKET_COUNT];
    }

    public CustomHashMapImpl(int size) {
        this.entryBuckets = new Entry[size];
    }

    @Override
    public void put(K key, V value) {
        Entry<K, V> newEntry = new Entry<K, V>(key, value);
        if (key == null) {
            throw new IllegalArgumentException("Key " + key + " cannot be null.");
        }
        int bucketIndex = findBucketUsingHashFunction(key.hashCode());
        // Nothing in the bucket. Its a first entry at that bucket[hashcode(key)]
        if (entryBuckets[bucketIndex] == null) {
            entryBuckets[bucketIndex] = newEntry;
        } else {
            Entry<K, V> entry = entryBuckets[bucketIndex];
            // If same key but different value, then update the value.
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
            } else {
                // Different key but same hashcode.. collision.. add to linkedlist
                while (entry.getNext() != null) {
                    entry = entry.getNext();
                }
                entry.setNext(newEntry);
            }
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key " + key + " cannot be null.");
        }
        int bucketIndex = findBucketUsingHashFunction(key.hashCode());
        Entry<K, V> entry = entryBuckets[bucketIndex];
        // Loop through bucket if multiple entries.
        // current entry will be found once the inputKey is equal to entryKey
        // Collisions: Two different keys have same hashCode. It results that both Entries with respective keys
        // are added into same bucket.
        while (entry != null && !key.equals(entry.getKey())) {
            entry = entry.getNext();
        }
        return entry != null ? entry.getValue() : null;
    }

    // This is the hashFunction which will decide on the bucket.
    private int findBucketUsingHashFunction(int hashCode) {
        return hashCode % entryBuckets.length;
    }

    @Override
    public boolean remove(K key) {
        return false;
    }

    private static class Entry<K, V> {

        private Entry<K, V> next;
        private final K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        private V getValue() {
            return value;
        }

        private void setValue(V value) {
            this.value = value;
        }

        private K getKey() {
            return key;
        }

        private Entry<K, V> getNext() {
            return next;
        }

        private void setNext(Entry<K, V> next) {
            this.next = next;
        }
    }
}
