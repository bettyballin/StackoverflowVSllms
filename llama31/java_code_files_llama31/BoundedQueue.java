/*
 * Decompiled with CFR 0.152.
 */
import java.util.LinkedHashMap;
import java.util.Map;

public class BoundedQueue<K, V>
extends LinkedHashMap<K, V> {
    private final int maxSize;

    public BoundedQueue(int n) {
        super(n, 0.75f, true);
        this.maxSize = n;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
        return this.size() > this.maxSize;
    }

    public void add(K k, V v) {
        this.put(k, v);
    }

    public static void main(String[] stringArray) {
        BoundedQueue<String, String> boundedQueue = new BoundedQueue<String, String>(3);
        boundedQueue.add("key1", "value1");
        boundedQueue.add("key2", "value2");
        boundedQueue.add("key3", "value3");
        boundedQueue.add("key4", "value4");
        System.out.println(boundedQueue);
    }
}
