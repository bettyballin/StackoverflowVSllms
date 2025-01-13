/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

public class DataCacheManager {
    Cache<String, List<MyPojo>> cache = new Cache();

    public DataCacheManager() {
        ArrayList arrayList = (ArrayList)this.cache.get((Object)"myKey");
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.cache.put((Object)"myKey", arrayList);
        }
    }

    public static void main(String[] stringArray) {
        new DataCacheManager();
    }
}
