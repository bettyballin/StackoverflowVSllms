import java.util.Map;

public class BinaryTreeMap<K, V> implements Map<K, V> {
    private Node<K, V> root;

    public BinaryTreeMap() {
        root = null;
    }

    @Override
    public V get(Object key) {
        Node<K, V> node = root;
        while (node != null) {
            int cmp = compare(key, node.key);
            if (cmp < 0) {
                node = node.left;
            } else if (cmp > 0) {
                node = node.right;
            } else {
                return node.value;
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        Node<K, V> node = root;
        while (node != null) {
            int cmp = compare(key, node.key);
            if (cmp < 0) {
                if (node.left == null) {
                    node.left = new Node<>(key, value);
                    return null;
                }
                node = node.left;
            } else if (cmp > 0) {
                if (node.right == null) {
                    node.right = new Node<>(key, value);
                    return null;
                }
                node = node.right;
            } else {
                node.value = value;
                return node.value;
            }
        }
        root = new Node<>(key, value);
        return null;
    }

    // other map methods...

    private int compare(Object o1, Object o2) {
        // implement comparison logic
        // for simplicity, let's assume we're comparing strings
        return o1.toString().compareTo(o2.toString());
    }

    private static class Node<K, V> {
        final K key;
        V value; // changed from final to non-final
        Node<K, V> left;
        Node<K, V> right;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        BinaryTreeMap<String, String> map = new BinaryTreeMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        System.out.println(map.get("key1")); // prints "value1"
    }
}