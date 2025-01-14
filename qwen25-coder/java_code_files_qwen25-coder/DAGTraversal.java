import java.util.HashSet;
import java.util.Set;

class Node {
    Set<Node> parents; // Assuming nodes keep track of their parents

    public Node() {
        this.parents = new HashSet<>();
    }
}

public class DAGTraversal {

    private Set<Node> visitedNodes = new HashSet<>();

    public Set<Node> findRootsFrom(Node node) {
        if (node == null || visitedNodes.contains(node)) {
            return new HashSet<>();
        }
        visitedNodes.add(node);
        
        Set<Node> roots = new HashSet<>();

        // If no parents, this is a root node
        if (node.parents.isEmpty()) {
            roots.add(node);
        } else {
            for (Node parent : node.parents) {
                roots.addAll(findRootsFrom(parent));
            }
        }

        return roots;
    }

    public static void main(String[] args) {
        // Example usage, assuming nodes are already linked properly
        Node startNode = new Node();
        // Connect nodes as per the graph structure

        DAGTraversal traversal = new DAGTraversal();
        Set<Node> roots = traversal.findRootsFrom(startNode);

        System.out.println("Reachable root nodes count: " + roots.size());
    }
}