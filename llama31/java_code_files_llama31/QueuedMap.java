/*
 * Decompiled with CFR 0.152.
 */
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class QueuedMap<K, V> {
    private final Deque<V> queue = new LinkedList<V>();
    private final Map<K, V> map = new HashMap();
    private final Map<V, K> reverseMap = new HashMap<V, K>();

    public void add(K k, V v) {
        this.queue.add(v);
        this.map.put(k, v);
        this.reverseMap.put(v, k);
    }

    public V remove() {
        V v = this.queue.poll();
        if (v != null) {
            this.map.remove(this.reverseMap.get(v));
            this.reverseMap.remove(v);
        }
        return v;
    }

    public V get(K k) {
        return this.map.get(k);
    }

    public static void main(String[] stringArray) {
        QueuedMap<String, Integer> queuedMap = new QueuedMap<String, Integer>();
        queuedMap.add("apple", 5);
        queuedMap.add("banana", 7);
        System.out.println(queuedMap.remove());
        System.out.println(queuedMap.get("banana"));
    }
}
