import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class TrieAutocomplete {

    private TrieNode root;

    public List<String> prefixSearch(String prefix) {
        TrieNode currentNode = root;
        int charIndex = 0;

        // Traverse the tree using the prefix
        while (currentNode != null && charIndex < prefix.length()) {
            String edgeLabel = currentNode.edgeLabel;
            if (!matchesPrefix(edgeLabel, prefix.substring(charIndex))) {
                return new ArrayList<>(); // No match found for prefix
            }
            // Move to the child node that matches the current part of the prefix
            currentNode = currentNode.children.get(edgeLabel);
            charIndex += edgeLabel.length();
        }

        // If we are here, the whole prefix was matched. Perform DFS from this node.
        List<String> results = new ArrayList<>();
        collectWords(currentNode, new StringBuilder(prefix.substring(0, charIndex - (currentNode == null ? 0 : currentNode.edgeLabel.length()))), results);
        return results;
    }

    private boolean matchesPrefix(String edgeLabel, String prefix) {
        if (prefix.length() < edgeLabel.length()) {
            return prefix.equals(edgeLabel.substring(0, prefix.length()));
        }
        return edgeLabel.equals(prefix.substring(0, edgeLabel.length()));
    }

    private void collectWords(TrieNode node, StringBuilder path, List<String> results) {
        if (node == null) return;
        path.append(node.edgeLabel);
        if (node.isLeaf()) {
            results.add(path.toString());
        }
        for (TrieNode child : node.children.values()) {
            collectWords(child, new StringBuilder(path), results);
        }
        path.setLength(path.length() - node.edgeLabel.length()); // Backtrack
    }

    public static void main(String[] args) {
        // Entry point
    }

    // Inner class for TrieNode
    private class TrieNode {
        String edgeLabel;
        Map<String, TrieNode> children;

        boolean isLeaf() {
            return children == null || children.isEmpty();
        }
    }
}