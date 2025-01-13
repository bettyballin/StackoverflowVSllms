import java.util.HashSet;
import java.util.Set;

// Assuming Node and Item classes are defined elsewhere
class Node {
    public boolean isItem() { return false; } // default implementation
    public Set<Node> getChildren() { return new HashSet<>(); } // default implementation
}

class Item extends Node {
    // implementation of Item class
}

public class ItemCollector {
    Set<Node> visited = new HashSet<>();
    Set<Item> result = new HashSet<>();

    public void dfs(Node node) {
        if (node.isItem()) {
            result.add((Item) node);
        }
        visited.add(node);
        for (Node child : node.getChildren()) {
            if (!visited.contains(child)) {
                dfs(child);
            }
        }
    }

    public static void main(String[] args) {
        // Create an instance of ItemCollector to use its methods
        ItemCollector collector = new ItemCollector();
        // Create a Node instance to start the DFS traversal
        Node root = new Node();
        // Perform DFS traversal starting from the root node
        collector.dfs(root);
    }
}