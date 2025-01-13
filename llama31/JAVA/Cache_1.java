import java.util.Map;
import java.util.HashMap;

public class Cache_1_1 {
    private Map<String, Entry> cache = new HashMap<>();

    public void set(String key, String value, long ttl) {
        cache.put(key, new Entry(value, System.currentTimeMillis() + ttl));
    }

    public String get(String key) {
        Entry entry = cache.get(key);
        if (entry != null && entry.expirationTime > System.currentTimeMillis()) {
            return entry.value;
        } else {
            return null;
        }
    }

    private static class Entry {
        String value;
        long expirationTime;

        public Entry(String value, long expirationTime) {
            this.value = value;
            this.expirationTime = expirationTime;
        }
    }

    public static void main(String[] args) {
        Cache_1 cache = new Cache_1();
        cache.set("key", "value", 10000);
        System.out.println(cache.get("key"));
    }
}