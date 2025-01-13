/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class DcomObjectCache {
    private final ConcurrentMap<String, DcomObject> cache = new ConcurrentHashMap<String, DcomObject>();

    public DcomObject getDcomObject(String string) {
        DcomObject dcomObject = (DcomObject)this.cache.get(string);
        if (dcomObject == null) {
            dcomObject = this.createDcomObject();
            this.cache.put(string, dcomObject);
        }
        return dcomObject;
    }

    public void releaseDcomObject(String string) {
        this.cache.remove(string);
    }

    private DcomObject createDcomObject() {
        return new DcomObject();
    }

    public static void main(String[] stringArray) {
        DcomObjectCache dcomObjectCache = new DcomObjectCache();
        DcomObject dcomObject = dcomObjectCache.getDcomObject("test");
        dcomObjectCache.releaseDcomObject("test");
    }
}
