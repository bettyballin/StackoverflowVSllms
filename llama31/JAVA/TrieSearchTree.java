import java.util.List;
import java.util.ArrayList;

class Node {
    private String key;
    private Node[] children;

    public Node(String key) {
        this.key = key;
        this.children = new Node[26]; // assuming keys are lowercase English letters
    }

    public String getKey() {
        return key;
    }

    public Node getChild(char c) {
        return children[c - 'a'];
    }

    public void setChild(char c, Node node) {
        children[c - 'a'] = node;
    }

    public List<Node> getChildren() {
        List<Node> list = new ArrayList<>();
        for (Node child : children) {
            if (child != null) {
                list.add(child);
            }
        }
        return list;
    }
}

public class TrieSearchTree {
    private Node root;

    public TrieSearchTree() {
        root = new Node("");
    }

    public List<String> prefixSearch(String prefix) {
        List<String> result = new ArrayList<>();
        Node node = findNode(prefix);
        if (node != null) {
            prefixSearch(node, prefix, result);
        }
        return result;
    }

    private void prefixSearch(Node node, String prefix, List<String> result) {
        if (node.getKey().startsWith(prefix)) {
            result.add(node.getKey());
        }
        for (Node child : node.getChildren()) {
            prefixSearch(child, prefix, result);
        }
    }

    private Node findNode(String prefix) {
        Node node = root;
        for (char c : prefix.toCharArray()) {
            node = node.getChild(c);
            if (node == null) {
                return null;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        TrieSearchTree trie = new TrieSearchTree();
        // example usage:
        Node node = trie.new Node("apple");
        trie.root.setChild('a', node);
        System.out.println(trie.prefixSearch("a"));
    }
}