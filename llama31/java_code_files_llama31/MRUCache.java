/*
 * Decompiled with CFR 0.152.
 */
import java.util.Hashtable;

public class MRUCache {
    private int capacity;
    private Hashtable<Object, Node> cache;
    private Node head;
    private Node tail;

    public MRUCache(int n) {
        this.capacity = n;
        this.cache = new Hashtable();
    }

    public Object get(Object object) {
        Node node = this.cache.get(object);
        if (node != null) {
            this.removeNode(node);
            this.addNodeToHead(node);
            return node.value;
        }
        return null;
    }

    public void put(Object object, Object object2) {
        Node node = new Node(this, object, object2);
        this.cache.put(object, node);
        this.addNodeToHead(node);
        if (this.cache.size() > this.capacity) {
            Node node2 = this.tail;
            this.removeNode(node2);
            this.cache.remove(node2.key);
        }
    }

    private void addNodeToHead(Node node) {
        node.prev = null;
        node.next = this.head;
        if (this.head != null) {
            this.head.prev = node;
        } else {
            this.tail = node;
        }
        this.head = node;
    }

    private void removeNode(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            this.head = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            this.tail = node.prev;
        }
    }

    public static void main(String[] stringArray) {
        MRUCache mRUCache = new MRUCache(3);
        mRUCache.put("key1", "value1");
        mRUCache.put("key2", "value2");
        mRUCache.put("key3", "value3");
        System.out.println(mRUCache.get("key1"));
        mRUCache.put("key4", "value4");
        System.out.println(mRUCache.get("key2"));
    }

    private class Node {
        Object key;
        Object value;
        Node prev;
        Node next;

        Node(MRUCache mRUCache, Object object, Object object2) {
            this.key = object;
            this.value = object2;
        }
    }
}
