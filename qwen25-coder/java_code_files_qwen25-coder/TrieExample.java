import java.util.HashMap;
import java.util.Map;

public class TrieExample {
    public static void main(String[] args) {
        Trie<String> trie = new Trie<>();

        trie.put("fully.qualified.ClassName.method", "Object1");
        trie.put("fully.qualified.ClassName2.method", "Object2");

        System.out.println(trie.get("fully.qualified.ClassName.method")); // Output: Object1
    }
}

class Trie<V> {
    private TrieNode<V> root;

    public Trie() {
        root = new TrieNode<>();
    }

    public void put(String key, V value) {
        TrieNode<V> node = root;
        for (char ch : key.toCharArray()) {
            node.children.putIfAbsent(ch, new TrieNode<>());
            node = node.children.get(ch);
        }
        node.value = value;
        node.isEndOfWord = true;
    }

    public V get(String key) {
        TrieNode<V> node = root;
        for (char ch : key.toCharArray()) {
            node = node.children.get(ch);
            if (node == null) {
                return null; // Key not found
            }
        }
        if (node.isEndOfWord) {
            return node.value;
        }
        return null; // Key not found
    }

    private static class TrieNode<V> {
        Map<Character, TrieNode<V>> children = new HashMap<>();
        V value;
        boolean isEndOfWord;
    }
}