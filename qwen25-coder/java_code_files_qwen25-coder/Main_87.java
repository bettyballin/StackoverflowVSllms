import java.util.HashMap;
import java.util.Map;

// Simple Trie Node class
class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean endOfWord;

    public void insert(String word) {
        TrieNode node = this;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode node = find(word);
        return node != null && node.endOfWord;
    }

    private TrieNode find(String prefix) {
        TrieNode node = this;
        for (char c : prefix.toCharArray()) {
            node = node.children.get(c);
            if (node == null) break;
        }
        return node;
    }
}

// Usage example
public class Main_87 {
    public static void main(String[] args) {
        // Hash Table Example
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("apple", "fruit");
        System.out.println(hashMap.get("apple")); // Outputs: fruit

        // Trie Example
        TrieNode trie = new TrieNode();
        trie.insert("apple");
        System.out.println(trie.search("apple")); // Outputs: true
    }
}