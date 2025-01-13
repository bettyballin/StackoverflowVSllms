import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.spy.memcached.MemcachedClient;

// Define the caching strategy interface
public interface CacheStrategy {
    void put(String key, Object value);
    Object get(String key);
    void remove(String key);
}

// Implement the caching strategies for Ehcache and Memcached
class EhcacheStrategy implements CacheStrategy {
    private final CacheManager cacheManager;

    public EhcacheStrategy(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @Override
    public void put(String key, Object value) {
        Cache cache = cacheManager.getCache("myCache");
        cache.put(new net.sf.ehcache.Element(key, value));
    }

    @Override
    public Object get(String key) {
        Cache cache = cacheManager.getCache("myCache");
        net.sf.ehcache.Element element = cache.get(key);
        return element == null ? null : element.getObjectValue();
    }

    @Override
    public void remove(String key) {
        Cache cache = cacheManager.getCache("myCache");
        cache.remove(key);
    }
}

class MemcachedStrategy implements CacheStrategy {
    private final MemcachedClient memcachedClient;

    public MemcachedStrategy(MemcachedClient memcachedClient) {
        this.memcachedClient = memcachedClient;
    }

    @Override
    public void put(String key, Object value) {
        memcachedClient.set(key, 0, value);
    }

    @Override
    public Object get(String key) {
        return memcachedClient.get(key);
    }

    @Override
    public void remove(String key) {
        memcachedClient.delete(key);
    }
}

// Use a factory to create the caching strategy instance based on configuration
class CacheFactory {
    public static CacheStrategy createCacheStrategy(String cacheType) {
        if ("ehcache".equals(cacheType)) {
            return new EhcacheStrategy(CacheManager.getInstance());
        } else if ("memcached".equals(cacheType)) {
            try {
                return new MemcachedStrategy(new MemcachedClient("localhost", 11211));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new UnsupportedOperationException("Unsupported cache type");
        }
    }
}

// Use the caching strategy in your application
public class MyService {
    private final CacheStrategy cacheStrategy;

    public MyService(CacheStrategy cacheStrategy) {
        this.cacheStrategy = cacheStrategy;
    }

    public void doSomething() {
        cacheStrategy.put("key", "value");
        Object value = cacheStrategy.get("key");
        System.out.println(value);
        cacheStrategy.remove("key");
    }

    public static void main(String[] args) {
        CacheStrategy cacheStrategy = CacheFactory.createCacheStrategy("ehcache");
        MyService myService = new MyService(cacheStrategy);
        myService.doSomething();
    }
}