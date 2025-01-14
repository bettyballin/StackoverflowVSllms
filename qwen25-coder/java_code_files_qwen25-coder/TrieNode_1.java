import java.util.HashMap;
import java.util.Map;

public class TrieNode_1 {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEndOfWord;
    }

    static class Trie {
        private final TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String str) {
            TrieNode node = root;
            for (char c : str.toCharArray()) {
                node.children.putIfAbsent(c, new TrieNode());
                node = node.children.get(c);
            }
            node.isEndOfWord = true;
        }

        // Additional methods like search and prefix matching would go here
    }

    public static void main(String[] args) {
    }
}