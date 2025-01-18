import java.util.LinkedHashMap;
import java.util.Map;

public class MRUCache<K, V> {
    private final int capacity;
    private final LinkedHashMap<K, V> cache;

    public MRUCache(int capacity) {
        this.capacity = capacity;
        // Using accessOrder=true to maintain access order
        this.cache = new LinkedHashMap<K, V>(capacity, 0.75f, true);
    }

    public void put(K key, V value) {
        if (cache.containsKey(key)) {
            cache.put(key, value); // Update value and move to most recently used position
        } else {
            if (cache.size() >= capacity) {
                // Remove the most recently used entry (last entry in the LinkedHashMap)
                K mostRecentKey = null;
                for (K k : cache.keySet()) {
                    mostRecentKey = k;
                }
                cache.remove(mostRecentKey);
            }
            cache.put(key, value);
        }
    }

    public V get(K key) {
        return cache.get(key); // Accessing the key moves it to most recently used position
    }

    public static void main(String[] args) {
        MRUCache<String, String> mru = new MRUCache<>(5);  // Cache for 5 objects
        mru.put("key", "value");   // Add to cache
        String value = mru.get("key");  // Get from cache and makes it most recently used
        System.out.println("Value for 'key': " + value);
    }
}