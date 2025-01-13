import java.util.*;

public class RootNodeFinder {
    private static class Node {
        List<Node> children;
        List<Node> parents;

        public Node() {
            children = new ArrayList<>();
            parents = new ArrayList<>();
        }
    }

    private Set<Node> visited;
    private Set<Node> potentialRoots;

    public Set<Node> findRootNodes(Node sourceNode) {
        visited = new HashSet<>();
        potentialRoots = new HashSet<>();

        dfsTraversal(sourceNode);

        // Verify potential root nodes
        Set<Node> rootNodes = new HashSet<>();
        for (Node potentialRoot : potentialRoots) {
            if (isRootNode(potentialRoot)) {
                rootNodes.add(potentialRoot);
            }
        }

        return rootNodes;
    }

    private void dfsTraversal(Node node) {
        visited.add(node);

        if (node.children.isEmpty()) {
            // Leaf node, mark as potential root
            potentialRoots.add(node);
        } else {
            for (Node child : node.children) {
                if (!visited.contains(child)) {
                    dfsTraversal(child);
                }
            }
        }
    }

    private boolean isRootNode(Node node) {
        // Perform reverse DFS traversal to verify if node has no parents
        Set<Node> visitedParents = new HashSet<>();
        return !hasParents(node, visitedParents);
    }

    private boolean hasParents(Node node, Set<Node> visitedParents) {
        visitedParents.add(node);

        for (Node parent : node.parents) {
            if (!visitedParents.contains(parent)) {
                if (!hasParents(parent, visitedParents)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        RootNodeFinder finder = new RootNodeFinder();
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();

        node1.children.add(node2);
        node2.children.add(node3);
        node2.parents.add(node1);
        node3.parents.add(node2);

        Set<Node> rootNodes = finder.findRootNodes(node1);
        System.out.println("Root nodes: " + rootNodes.size());
    }
}