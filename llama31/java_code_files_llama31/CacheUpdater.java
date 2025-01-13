/*
 * Decompiled with CFR 0.152.
 */
public class CacheUpdater {
    private static final Object lock = new Object();
    private static Cache cache;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateCache() {
        Object object = lock;
        synchronized (object) {
            cache = new Cache();
        }
    }

    public static void main(String[] stringArray) {
        CacheUpdater cacheUpdater = new CacheUpdater();
        cacheUpdater.updateCache();
    }
}
