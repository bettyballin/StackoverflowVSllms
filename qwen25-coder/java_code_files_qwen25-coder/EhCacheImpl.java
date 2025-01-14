public interface Cache {
    void put(String key, Object value);
    Object get(String key);
    boolean remove(String key);
}

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

public class EhCacheImpl implements Cache {
    private final Ehcache cache;

    public EhCacheImpl(CacheManager cacheManager) {
        this.cache = cacheManager.getCache("myCache");
    }

    @Override
    public void put(String key, Object value) {
        cache.put(new Element(key, value));
    }

    @Override
    public Object get(String key) {
        Element element = cache.get(key);
        return (element != null) ? element.getObjectValue() : null;
    }

    @Override
    public boolean remove(String key) {
        return cache.remove(key);
    }

    public static void main(String[] args) {
        // Example usage (requires ehcache configuration)
        CacheManager cacheManager = CacheManager.newInstance();
        EhCacheImpl myCache = new EhCacheImpl(cacheManager);
        myCache.put("key", "value");
        System.out.println(myCache.get("key"));
        myCache.remove("key");
    }
}