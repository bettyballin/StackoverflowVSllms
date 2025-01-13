import java.util.List;
import java.util.ArrayList;

public class DepthFirstSearch {
    private static void dfs(Node node, boolean[] visited) {
        visited[node.getIndex()] = true;
        System.out.print(node.getValue() + " ");

        for (Node neighbor : node.getNeighbors()) {
            if (!visited[neighbor.getIndex()]) {
                dfs(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        // Create a graph
        Node[] nodes = new Node[5];
        nodes[0] = new Node(0, "A");
        nodes[1] = new Node(1, "B");
        nodes[2] = new Node(2, "C");
        nodes[3] = new Node(3, "D");
        nodes[4] = new Node(4, "E");

        // Add neighbors
        nodes[0].addNeighbor(nodes[1]);
        nodes[0].addNeighbor(nodes[2]);
        nodes[1].addNeighbor(nodes[3]);
        nodes[2].addNeighbor(nodes[4]);

        // Perform DFS
        boolean[] visited = new boolean[nodes.length];
        dfs(nodes[0], visited);
    }
}

class Node {
    private int index;
    private String value;
    private List<Node> neighbors;

    public Node(int index, String value) {
        this.index = index;
        this.value = value;
        this.neighbors = new ArrayList<>();
    }

    public int getIndex() {
        return index;
    }

    public String getValue() {
        return value;
    }

    public List<Node> getNeighbors() {
        return neighbors;
    }

    public void addNeighbor(Node neighbor) {
        neighbors.add(neighbor);
    }
}