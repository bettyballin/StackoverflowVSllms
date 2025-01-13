// Define the BoundedQueue class
class BoundedQueue<K, V> {
    private final int capacity;
    private final java.util.Map<K, V> map;
    private final java.util.Deque<K> deque;

    public BoundedQueue(int capacity) {
        this.capacity = capacity;
        this.map = new java.util.LinkedHashMap<>();
        this.deque = new java.util.ArrayDeque<>();
    }

    public void add(K key, V value) {
        if (map.size() >= capacity) {
            K oldestKey = deque.poll();
            map.remove(oldestKey);
        }
        map.put(key, value);
        deque.offer(key);
    }

    public static void main(String[] args) {
        // Create a new BoundedQueue
        BoundedQueue<String, String> queue = new BoundedQueue<>(10);

        // Add elements to the queue
        queue.add("key1", "value1");
        queue.add("key2", "value2");
        // ...
    }
}