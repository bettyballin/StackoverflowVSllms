import java.lang.String;
import java.util.HashMap;
import java.util.Map;
public class CacheManager_1 {
    private final Map<String, Object> cache = new HashMap<>();

    public synchronized void addToCache(String key, Object value) {
        cache.put(key, value);
    }

    public static void main(String[] args) {
    }
}