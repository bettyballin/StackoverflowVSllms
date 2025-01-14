import java.lang.String;
import java.util.Hashtable;

class Node {
    Object key;
    Object value;
    Node prev;
    Node next;

    Node(Object k, Object v) {
        this.key = k;
        this.value = v;
    }
}

public class LRUCache {
    private final int capacity;
    private Hashtable<Object, Node> table;
    private Node head;
    private Node tail;

    public LRUCache(int size) {
        this.capacity = size;
        table = new Hashtable<>(capacity);
        head = new Node(null, null); // Sentinel node
        tail = new Node(null, null); // Sentinel node
        head.next = tail;
        tail.prev = head;
    }

    private void removeNode(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    private void addToFront(Node n) {
        n.prev = head;
        n.next = head.next;

        head.next.prev = n;
        head.next = n;
    }

    public Object get(Object key) {
        Node n = table.get(key);
        if (n == null)
            return null;
        
        removeNode(n);
        addToFront(n);
        return n.value;
    }

    public void put(Object key, Object value) {
        Node n = table.get(key);
        if (n != null) { // Update existing node
            n.value = value;
            removeNode(n);
            addToFront(n);
        } else { // Insert new node
            if (table.size() == capacity)
                table.remove(removeLast().key);

            Node newNode = new Node(key, value);
            table.put(key, newNode);
            addToFront(newNode);
        }
    }

    private Node removeLast() {
        if (tail.prev == head) return null;
        Node n = tail.prev;
        removeNode(n);
        return n;
    }

	public static void main(String[] args) {
	}
}