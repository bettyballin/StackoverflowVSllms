package spi;

import java.lang.String;
import java.util.Iterator;
import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.spi.CachingProvider;
import java.util.ServiceLoader;

public final class DynamicCacheFactory {

    private static Cache<String,String> cache = null;

    public static CachingProvider cachingProviderInstance() {
        Iterator<CachingProvider> iterator = ServiceLoader.load(CachingProvider.class).iterator();
        // Return first available provider, assuming the system won't have more than one Caching Providers installed at a time.
        if (!iterator.hasNext()) { throw new RuntimeException("cachng proviers not found"); }
        return iterator.next();
    }

    public static Cache<String,String> cacheInstance() {
        if (cache == null) { // if it's already set, then no need to create again and again as it is a singleton object anyway.
            CachingProvider cachingProvider = DynamicCacheFactory.cachingProviderInstance();
            CacheManager cm = cachingProvider.getCacheManager(); // you might have other ways to get the cache manager, use that here based on your need.
            if (cm != null) { // if we were able to find our CacheManager instance then fetch/create our caches.
                cache = cm.getCache("spi", String.class, String.class); // or any other way, based on your requirement and usage
            } else {
                throw new RuntimeException("caching manager not found");
            }
        }
        return cache;
    }

    public static void main(String[] args) {
    }

}