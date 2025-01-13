/*
 * Decompiled with CFR 0.152.
 */
private class Cache.CacheEntry {
    String data;
    long expiration;

    Cache.CacheEntry(Cache cache, String string, long l) {
        this.data = string;
        this.expiration = l;
    }
}
