import java.util.*;

public class LRUCache<K, V> {
    private static final float hashTableLoadFactor = 0.75f;
    private LinkedHashMap<K, V> map;
    private int cacheSize;

    public LRUCache(int size) {
        this.cacheSize = size;
        int hashTableCapacity = (int) Math.ceil(size / hashTableLoadFactor) + 1;
        map = new LinkedHashMap<K, V>(hashTableCapacity, hashTableLoadFactor, true) { // true for access order
            private final long serialVersionUID = 100920485236750L;

            // (an anonymous inner class)
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                // The size test must come first before the other code to avoid null pointer exception when size becomes zero
                return (size() > LRUCache.this.cacheSize);
            }
        };
    }

    public V put(K key, V value) {
        return map.put(key, value);
    }

    public synchronized int size() {
        return map.size(); // In case of multi-threaded application
    }

    public synchronized boolean containsKey(K key) {
        return map.containsKey(key); // The same here too
    }

    public V get(K key) {
        return map.get(key);
    }
}