import java.util.HashMap;
import java.util.Map;

// Define a simple Trie class
class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String key, String value) {
        Node current = root;
        for (char c : key.toCharArray()) {
            current = current.getChildren().computeIfAbsent(c, k -> new Node());
        }
        current.setValue(value);
    }

    public String get(String key) {
        Node current = root;
        for (char c : key.toCharArray()) {
            current = current.getChildren().get(c);
            if (current == null) {
                return null;
            }
        }
        return current.getValue();
    }

    private static class Node {
        private String value;
        private Map<Character, Node> children = new HashMap<>();

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Map<Character, Node> getChildren() {
            return children;
        }
    }
}

public class Main_540 {
    public static void main(String[] args) {
        // Hash Table (HashMap)
        Map<String, String> hashTable = new HashMap<>();
        hashTable.put("hello", "world");
        String hashTableValue = hashTable.get("hello"); // Fast lookup
        System.out.println(hashTableValue);

        // Trie (Prefix Tree)
        Trie trie = new Trie();
        trie.insert("hello", "world");
        String trieValue = trie.get("hello"); // Prefix matching
        System.out.println(trieValue);
    }
}