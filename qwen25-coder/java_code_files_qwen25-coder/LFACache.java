import java.util.*;

public class LFACache<K, V> {
    private final int capacity;
    private final LinkedHashMap<K, CacheEntry> map;
    private final TreeMap<Integer, LinkedHashSet<K>> freq;

    class CacheEntry {
        V val;
        int count;

        CacheEntry(V val) {
            this.val = val;
            this.count = 0;
        }
    }

    public LFACache(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("Capacity must be positive");
        this.capacity = capacity;
        map = new LinkedHashMap<>();
        freq = new TreeMap<>();
        freq.put(0, new LinkedHashSet<>());
    }

    public V get(K key) {
        CacheEntry entry = map.get(key);
        if (entry == null) return null;

        removeKeyFromFreq(entry.count++, key);

        freq.computeIfAbsent(entry.count, k -> new LinkedHashSet<>()).add(key);
        return entry.val;
    }

    public void put(K key, V value) {
        if (capacity <= 0) return;

        CacheEntry entry = map.get(key);
        if (entry != null) {
            entry.val = value;
            get(key); // This will update the frequency
            return;
        } else {
            if (map.size() >= capacity)
                removeLeastFrequentItem();

            freq.get(0).add(key);
            map.put(key, new CacheEntry(value));
        }
    }

    private void removeLeastFrequentItem() {
        int minFreq = freq.firstKey();
        K keyToRemove = freq.get(minFreq).iterator().next();

        freq.get(minFreq).remove(keyToRemove);
        if (freq.get(minFreq).isEmpty())
            freq.remove(minFreq);

        map.remove(keyToRemove);
    }

    private void removeKeyFromFreq(int count, K key) {
        freq.get(count).remove(key);
        if (freq.get(count).isEmpty()) {
            freq.remove(count);
        }
    }

    public static void main(String[] args) {
        LFACache<Integer, Integer> cache = new LFACache<>(2 /* capacity */);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2) != null ? cache.get(2) : -1);       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1) != null ? cache.get(1) : -1);       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}