/*
 * Decompiled with CFR 0.152.
 */
public class DataCache {
    private static final int CACHE_EXPIRATION = 3600;
    private static Cache cache = new Cache();

    public void cacheData(String string, String string2) {
        cache.put(string, string2, 3600);
    }

    public void retrieveData(String string, AsyncCallback<String> asyncCallback) {
        String string2 = cache.get(string);
        if (string2 != null) {
            asyncCallback.onSuccess(string2);
        }
    }

    public static void main(String[] stringArray) {
        DataCache dataCache = new DataCache();
        dataCache.cacheData("testKey", "testData");
        dataCache.retrieveData("testKey", new AsyncCallback<String>(){

            @Override
            public void onSuccess(String string) {
                System.out.println("Retrieved data: " + string);
            }
        });
    }
}
