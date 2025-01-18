import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        LRUCache<String, String> myCache = new LRUCache<>(10); // creates a cache of size 10
        myCache.put("one", "first"); // adds an item to the cache
        System.out.println(myCache.get("one")); // outputs: "first" -> retrieves from Cache
    }
}

class LRUCache<K, V> {
    private final int capacity;
    private HashMap<K, Node<K, V>> map;
    private Node<K, V> head;
    private Node<K, V> tail;

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public V get(K key) {
        if (map.containsKey(key)) {
            Node<K, V> n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }
        return null;
    }

    public void put(K key, V value) {
        if (map.containsKey(key)) {
            Node<K, V> n = map.get(key);
            n.value = value;
            remove(n);
            setHead(n);
        } else {
            Node<K, V> n = new Node<>(key, value);
            if (map.size() >= capacity) {
                map.remove(tail.key);
                remove(tail);
            }
            setHead(n);
            map.put(key, n);
        }
    }

    private void remove(Node<K, V> node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }

    private void setHead(Node<K, V> node) {
        node.next = head;
        node.prev = null;

        if (head != null) {
            head.prev = node;
        }

        head = node;

        if (tail == null) {
            tail = head;
        }
    }
}