/*
 * Decompiled with CFR 0.152.
 */
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V>
extends LinkedHashMap<K, V> {
    private final int maxEntries;

    public LRUCache(int n) {
        super(n, 0.75f, true);
        this.maxEntries = n;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
        return this.size() > this.maxEntries;
    }

    public static void main(String[] stringArray) {
        LRUCache<String, String> lRUCache = new LRUCache<String, String>(2);
        lRUCache.put("key1", "value1");
        lRUCache.put("key2", "value2");
        lRUCache.put("key3", "value3");
        System.out.println(lRUCache);
    }
}
