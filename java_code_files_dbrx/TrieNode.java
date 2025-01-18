import java.util.HashMap;

public class Trie {
    class TrieNode {
        char ch;
        int count;
        boolean endOfWord;
        HashMap<Character, TrieNode> children = new HashMap<>();

        TrieNode(char c) {
            this.ch = c;
            this.count = 0;
            this.endOfWord = false;
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode('\0');
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode(c));
            }
            node = node.children.get(c);
            node.count++;
        }
        node.endOfWord = true;
    }

    public static void main(String[] args) {
    }
}