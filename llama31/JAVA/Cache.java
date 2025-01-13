import java.lang.String;
import java.util.Map;
import java.util.HashMap;

public class Cache {
    private Map<String, Entry> cache = new HashMap<>();

    public void set(String key, String value, int version) {
        cache.put(key, new Entry(value, version));
    }

    public String get(String key, int expectedVersion) {
        Entry entry = cache.get(key);
        if (entry != null && entry.version == expectedVersion) {
            return entry.value;
        } else {
            return null;
        }
    }

    private static class Entry {
        String value;
        int version;

        public Entry(String value, int version) {
            this.value = value;
            this.version = version;
        }
    }

    public static void main(String[] args) {
        Cache cache = new Cache();
        cache.set("key", "value", 1);
        System.out.println(cache.get("key", 1)); // prints: value
        System.out.println(cache.get("key", 2)); // prints: null
    }
}