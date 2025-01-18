import java.util.*;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int cacheSize;

    public LRUCache(int cacheSize) {
        // Set accessOrder to true for Least Recently Used (LRU) ordering
        super((int) (cacheSize / 0.75) + 1, 0.75f, true);
        this.cacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        // Override to customize eviction conditions
        return size() > cacheSize;
        // Limit the number of items in LRU Cache -> if more than (cache capacity), it should automatically delete the oldest one.
    }

    public static void main(String[] args) {
    }
}