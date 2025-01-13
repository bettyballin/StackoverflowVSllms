import java.util.Hashtable;

public class MRUCache {
    private int capacity;
    private Hashtable<Object, Node> cache;
    private Node head; // most recently used
    private Node tail; // least recently used

    public MRUCache(int capacity) {
        this.capacity = capacity;
        cache = new Hashtable<>();
    }

    public Object get(Object key) {
        Node node = cache.get(key);
        if (node != null) {
            // move node to head (most recently used)
            removeNode(node);
            addNodeToHead(node);
            return node.value;
        }
        return null;
    }

    public void put(Object key, Object value) {
        Node node = new Node(key, value);
        cache.put(key, node);
        addNodeToHead(node);
        if (cache.size() > capacity) {
            // purge least recently used
            Node lru = tail;
            removeNode(lru);
            cache.remove(lru.key);
        }
    }

    private void addNodeToHead(Node node) {
        node.prev = null;
        node.next = head;
        if (head != null) {
            head.prev = node;
        } else {
            tail = node;
        }
        head = node;
    }

    private void removeNode(Node node) {
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

    private class Node {
        Object key;
        Object value;
        Node prev;
        Node next;

        Node(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        MRUCache cache = new MRUCache(3);
        cache.put("key1", "value1");
        cache.put("key2", "value2");
        cache.put("key3", "value3");
        System.out.println(cache.get("key1")); // should print "value1"
        cache.put("key4", "value4");
        System.out.println(cache.get("key2")); // should print null
    }
}