import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaxCache {
    private Map<String, Integer> cacheMap; // Hash Map
    private PriorityQueue<Integer> maxHeap; // Max Heap

    public MaxCache() {
        cacheMap = new HashMap<>();
        maxHeap = new PriorityQueue<>((a, b) -> b - a); // Max Heap comparator
    }

    public void insert(String key, int value) {
        cacheMap.put(key, value);
        maxHeap.add(value);
    }

    public void delete(String key) {
        if (cacheMap.containsKey(key)) {
            int value = cacheMap.remove(key);
            maxHeap.remove(value);
        }
    }

    public int getMaxValue() {
        return maxHeap.peek(); // Return the maximum element
    }

    public static void main(String[] args) {
        MaxCache cache = new MaxCache();
        cache.insert("key1", 10);
        cache.insert("key2", 20);
        cache.insert("key3", 30);

        System.out.println("Max value: " + cache.getMaxValue()); // prints 30

        cache.delete("key3");
        System.out.println("Max value: " + cache.getMaxValue()); // prints 20
    }
}