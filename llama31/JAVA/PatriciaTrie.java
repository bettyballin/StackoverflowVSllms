import java.util.HashMap;
import java.util.Map;

public class PatriciaTrie {
    private PatriciaTrieNode root;

    public PatriciaTrie() {
        this.root = new PatriciaTrieNode("", null);
    }

    public void insert(String key, Object value) {
        insert(root, key, value, 0);
    }

    private void insert(PatriciaTrieNode node, String key, Object value, int index) {
        if (index == key.length()) {
            node.setValue(value);
        } else {
            char c = key.charAt(index);
            PatriciaTrieNode child = node.getChildren().get(c);
            if (child == null) {
                child = new PatriciaTrieNode(key.substring(0, index + 1), null);
                node.getChildren().put(c, child);
            }
            insert(child, key, value, index + 1);
        }
    }

    public static void main(String[] args) {
        PatriciaTrie trie = new PatriciaTrie();
        trie.insert("apple", "fruit");
        trie.insert("banana", "fruit");
        trie.insert("carrot", "vegetable");
    }
}

class PatriciaTrieNode {
    private String key;
    private Object value;
    private Map<Character, PatriciaTrieNode> children;

    public PatriciaTrieNode(String key, Object value) {
        this.key = key;
        this.value = value;
        this.children = new HashMap<>();
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Map<Character, PatriciaTrieNode> getChildren() {
        return children;
    }
}