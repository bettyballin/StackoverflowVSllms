// Example of using Java's built-in caching API (Ehcache)
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

public class Main_83 {
    public static void main(String[] args) {
        // Create a cache manager
        CacheManager cacheManager = CacheManager.getInstance();

        // Create a cache
        Cache cache = cacheManager.getCache("myCache");
        if (cache == null) {
            cacheManager.addCache("myCache");
            cache = cacheManager.getCache("myCache");
        }

        // Store data in the cache
        cache.put(new Element("key", "value"));

        // Retrieve data from the cache
        Element element = cache.get("key");
        String value = (String) element.getObjectValue();

        System.out.println(value);
    }
}