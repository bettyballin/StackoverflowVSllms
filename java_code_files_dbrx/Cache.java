import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Cache {
    private HashMap<Integer, Node> hashMap; // The actual cache that stores key-value pairs
    private PriorityQueue<Node> pq;            // Maintains max heap property for the values in the cache

    public Cache() {
        this.hashMap = new HashMap<>();
        this.pq      = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                if (n1.getValue() < n2.getValue())   return -1; // Smaller values are placed lower in the heap due to max-heap property
                else if (n1.getValue() > n2.getValue())    return 1;
                else                            return 0;       // Both equal nodes will be ordered based on their original index in case of value equality
            }
        });
    }

    public void put(int key, int value) {
        Node newNode = new Node(value, hashMap.size()); // Create a node for the cache and Priority Queue representing this element
        hashMap.put(key, newNode);             // Add it to HashMap with key as the id of data
        pq.add(newNode);                      // Add it to PQ representing Max heap property for cache content
    }

    public int getMax() {            // Get max value from priority queue in O(1) time complexity
        return (pq.peek()).getValue();
    }

    public void delete(int key) {     // Delete operation
        Node removedNode = hashMap.remove(key);    // Remove it from HashMap and keep a reference
        pq.remove(removedNode);                     // Remove it from priority queue using the saved node instance
    }

    public static void main(String[] args) {
        // Example usage
        Cache cache = new Cache();
        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(3, 15);
        System.out.println("Max Value: " + cache.getMax()); // Should print 20
        cache.delete(2);
        System.out.println("Max Value after deletion: " + cache.getMax()); // Should print 15
    }
}

class Node {
    private int value;
    private int index; // Used for ordering when values are equal

    public Node(int value, int index) {
        this.value = value;
        this.index = index;
    }

    public int getValue() {
        return this.value;
    }

    public int getIndex() {
        return this.index;
    }

    // Override equals and hashCode so that removal from PriorityQueue works as expected
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;
        return value == node.value && index == node.index;
    }

    @Override
    public int hashCode() {
        int result = value;
        result = 31 * result + index;
        return result;
    }
}