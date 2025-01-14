import java.util.*;

class Node {
    int id; // Unique identifier for the node
    Node parent;

    public Node(int id, Node parent) {
        this.id = id;
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Node{" + "id=" + id + '}';
    }
}

public class TreeTraversal_3 {

    private Map<Node, List<Node>> childrenMap = new HashMap<>();

    public void buildChildrenMap(Collection<Node> allNodes) {
        for (Node node : allNodes) {
            if (node.parent != null) {
                childrenMap.computeIfAbsent(node.parent, k -> new ArrayList<>()).add(node);
            }
        }
    }

    public Collection<Node> getDescendants(Node root) {
        Set<Node> descendants = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            Collection<Node> children = childrenMap.getOrDefault(currentNode, Collections.emptyList());
            for (Node child : children) {
                if (descendants.add(child)) { // add() returns false if the set already contains the specified element
                    queue.add(child);
                }
            }
        }

        return descendants;
    }

    public static void main(String[] args) {
        // You can add test code here to run the TreeTraversal_3 class
    }
}