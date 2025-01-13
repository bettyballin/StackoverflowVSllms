/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaxCache {
    private Map<String, Integer> cacheMap = new HashMap<String, Integer>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue((n, n2) -> n2 - n);

    public void insert(String string, int n) {
        this.cacheMap.put(string, n);
        this.maxHeap.add(n);
    }

    public void delete(String string) {
        if (this.cacheMap.containsKey(string)) {
            int n = this.cacheMap.remove(string);
            this.maxHeap.remove(n);
        }
    }

    public int getMaxValue() {
        return this.maxHeap.peek();
    }

    public static void main(String[] stringArray) {
        MaxCache maxCache = new MaxCache();
        maxCache.insert("key1", 10);
        maxCache.insert("key2", 20);
        maxCache.insert("key3", 30);
        System.out.println("Max value: " + maxCache.getMaxValue());
        maxCache.delete("key3");
        System.out.println("Max value: " + maxCache.getMaxValue());
    }
}
