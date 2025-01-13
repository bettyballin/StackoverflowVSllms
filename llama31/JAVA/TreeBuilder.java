import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
    int ID;
    Integer ParentID; // Changed to Integer to allow null values
    List<Node> children = new ArrayList<>();

    public Node(int ID, Integer ParentID) {
        this.ID = ID;
        this.ParentID = ParentID;
    }
}

public class TreeBuilder {
    public static List<Node> buildTrees(List<Node> flatNodes) {
        Map<Integer, Node> nodeDictionary = new HashMap<>();

        // Create nodes and store in dictionary
        for (Node node : flatNodes) {
            nodeDictionary.put(node.ID, node);
        }

        // Build tree structure
        for (Node node : flatNodes) {
            if (node.ParentID != null) {
                Node parentNode = nodeDictionary.get(node.ParentID);
                if (parentNode != null) {
                    parentNode.children.add(node);
                }
            }
        }

        // Find root nodes
        List<Node> rootNodes = new ArrayList<>();
        for (Node node : nodeDictionary.values()) {
            if (node.ParentID == null || !nodeDictionary.containsKey(node.ParentID)) {
                rootNodes.add(node);
            }
        }

        return rootNodes;
    }

    public static void main(String[] args) {
        // Example usage:
        List<Node> flatNodes = new ArrayList<>();
        flatNodes.add(new Node(1, null));
        flatNodes.add(new Node(2, 1));
        flatNodes.add(new Node(3, 1));
        flatNodes.add(new Node(4, 2));
        flatNodes.add(new Node(5, 3));

        List<Node> rootNodes = buildTrees(flatNodes);
        System.out.println("Root nodes: " + rootNodes);
    }
}