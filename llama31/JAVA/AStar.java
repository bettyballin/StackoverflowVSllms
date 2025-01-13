import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// Define Node class
class Node implements Comparable<Node> {
    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return x == node.x && y == node.y;
    }

    @Override
    public int hashCode() {
        return 31 * x + y;
    }

    @Override
    public int compareTo(Node other) {
        return Double.compare(0, heuristic(this, other)); // dummy comparison
    }
}

// Define Edge class
class Edge {
    private Node destination;
    private double weight;

    public Edge(Node destination, double weight) {
        this.destination = destination;
        this.weight = weight;
    }

    public Node getDestination() {
        return destination;
    }

    public double getWeight() {
        return weight;
    }
}

// Define Graph class
class Graph {
    private Map<Node, List<Edge>> edges;

    public Graph() {
        edges = new HashMap<>();
    }

    public void addEdge(Node node, Edge edge) {
        edges.computeIfAbsent(node, k -> new ArrayList<>()).add(edge);
    }

    public List<Edge> getEdges(Node node) {
        return edges.getOrDefault(node, new ArrayList<>());
    }
}

public class AStar {
    public static List<Node> findPath(Node start, Node end, Graph graph) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(start);

        Map<Node, Node> cameFrom = new HashMap<>();
        Map<Node, Double> gScore = new HashMap<>();
        Map<Node, Double> fScore = new HashMap<>();

        gScore.put(start, 0.0);
        fScore.put(start, heuristic(start, end));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.equals(end)) {
                List<Node> path = new ArrayList<>();
                while (current != start) {
                    path.add(0, current);
                    current = cameFrom.get(current);
                }
                path.add(0, start);
                return path;
            }

            for (Edge edge : graph.getEdges(current)) {
                Node neighbor = edge.getDestination();
                double tentativeGScore = gScore.get(current) + edge.getWeight();

                if (!gScore.containsKey(neighbor) || tentativeGScore < gScore.get(neighbor)) {
                    cameFrom.put(neighbor, current);
                    gScore.put(neighbor, tentativeGScore);
                    fScore.put(neighbor, tentativeGScore + heuristic(neighbor, end));
                    queue.add(neighbor);
                }
            }
        }

        return null;
    }

    private static double heuristic(Node node, Node end) {
        // Manhattan distance heuristic
        return Math.abs(node.getX() - end.getX()) + Math.abs(node.getY() - end.getY());
    }

    public static void main(String[] args) {
        // Example usage
        Graph graph = new Graph();
        Node start = new Node(0, 0);
        Node end = new Node(3, 3);
        graph.addEdge(start, new Edge(new Node(1, 0), 1));
        graph.addEdge(new Node(1, 0), new Edge(new Node(2, 0), 1));
        graph.addEdge(new Node(2, 0), new Edge(new Node(2, 1), 1));
        graph.addEdge(new Node(2, 1), new Edge(new Node(2, 2), 1));
        graph.addEdge(new Node(2, 2), new Edge(end, 1));

        List<Node> path = findPath(start, end, graph);
        if (path != null) {
            System.out.println("Path found: " + path);
        } else {
            System.out.println("No path found");
        }
    }
}