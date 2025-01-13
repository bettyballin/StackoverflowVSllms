import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int maxEntries;

    public LRUCache(int maxEntries) {
        super(maxEntries, 0.75f, true);
        this.maxEntries = maxEntries;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > maxEntries;
    }

    public static void main(String[] args) {
        // Example usage:
        LRUCache<String, String> cache = new LRUCache<>(2);
        cache.put("key1", "value1");
        cache.put("key2", "value2");
        cache.put("key3", "value3"); // This will remove the eldest entry
        System.out.println(cache); // Print the cache content
    }
}