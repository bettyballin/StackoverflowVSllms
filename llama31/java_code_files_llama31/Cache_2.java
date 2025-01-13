/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.ConcurrentHashMap;

public class Cache_2 {
    private final ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap();
    private final Object file = new Object();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void deleteRecord(int n) {
        Object object = this.file;
        synchronized (object) {
            this.map.remove(n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void writeRecord(int n, String string) {
        Object object = this.file;
        synchronized (object) {
            this.map.put(n, string);
        }
    }

    public String getRecord(int n) {
        return this.map.get(n);
    }

    public static void main(String[] stringArray) {
    }
}
