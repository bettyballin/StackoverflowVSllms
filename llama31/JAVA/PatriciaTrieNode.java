import java.util.Map;
import java.util.HashMap;

public class PatriciaTrieNode {
    private String key;
    private Object value;
    private Map<Character, PatriciaTrieNode> children;

    public PatriciaTrieNode(String key, Object value) {
        this.key = key;
        this.value = value;
        this.children = new HashMap<>();
    }

    // getters and setters

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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

    public void setChildren(Map<Character, PatriciaTrieNode> children) {
        this.children = children;
    }

    public static void main(String[] args) {
        // Example usage
        PatriciaTrieNode node = new PatriciaTrieNode("root", "value");
        System.out.println(node.getKey());  // prints: root
        System.out.println(node.getValue());  // prints: value
    }
}