/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

class Cache {
    private ConcurrentMap<String, CacheEntry> cache = new ConcurrentHashMap<String, CacheEntry>();

    Cache() {
    }

    public void put(String string, String string2, int n) {
        this.cache.put(string, new CacheEntry(this, string2, System.currentTimeMillis() + (long)(n * 1000)));
    }

    public String get(String string) {
        CacheEntry cacheEntry = (CacheEntry)this.cache.get(string);
        if (cacheEntry != null && cacheEntry.expiration > System.currentTimeMillis()) {
            return cacheEntry.data;
        }
        this.cache.remove(string);
        return null;
    }

    private class CacheEntry {
        String data;
        long expiration;

        CacheEntry(Cache cache, String string, long l) {
            this.data = string;
            this.expiration = l;
        }
    }
}
