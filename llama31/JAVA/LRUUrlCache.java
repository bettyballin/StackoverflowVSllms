import java.util.LinkedHashMap;
import java.util.Map;

public class LRUUrlCache extends LinkedHashMap<String, Long> {
    private final int maxSize;

    public LRUUrlCache(int maxSize) {
        super(16, 0.75f, true); // access ordering
        this.maxSize = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<String, Long> eldest) {
        return size() > maxSize;
    }

    public void addUrl(String url) {
        put(url, System.currentTimeMillis());
    }

    public static void main(String[] args) {
        // Example usage:
        LRUUrlCache cache = new LRUUrlCache(5);
        cache.addUrl("http://example.com");
        cache.addUrl("http://example.org");
        cache.addUrl("http://example.net");
        System.out.println(cache);
    }
}