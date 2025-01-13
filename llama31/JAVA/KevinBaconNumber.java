import java.util.*;

// Define Node class
class Node {
    String name;

    public Node(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(name, node.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

// Define Graph class
class Graph {
    private Map<Node, List<Node>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addNode(Node node) {
        adjacencyList.put(node, new ArrayList<>());
    }

    public void addEdge(Node source, Node target) {
        adjacencyList.get(source).add(target);
        adjacencyList.get(target).add(source); // Assuming undirected graph
    }

    public List<Node> getNeighbors(Node node) {
        return adjacencyList.get(node);
    }
}

public class KevinBaconNumber {
    public static int calculateKevinBaconNumber(Graph graph, Node source, Node target) {
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        // Start from source node
        queue.add(source);
        visited.add(source);
        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.equals(target)) {
                    return distance; // Target node found
                }

                for (Node neighbor : graph.getNeighbors(node)) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            distance++;
        }

        // Start from target node
        queue.clear();
        queue.add(target);
        visited.clear();
        visited.add(target);
        distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.equals(source)) {
                    return distance; // Source node found
                }

                for (Node neighbor : graph.getNeighbors(node)) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            distance++;
        }

        return -1; // No path found
    }

    public static void main(String[] args) {
        // Example usage
        Graph graph = new Graph();
        Node source = new Node("Kevin Bacon");
        Node target = new Node("Tom Hanks");
        Node intermediate = new Node("Meg Ryan");

        graph.addNode(source);
        graph.addNode(target);
        graph.addNode(intermediate);

        graph.addEdge(source, intermediate);
        graph.addEdge(intermediate, target);

        int kevinBaconNumber = calculateKevinBaconNumber(graph, source, target);
        System.out.println("Kevin Bacon Number: " + kevinBaconNumber);
    }
}