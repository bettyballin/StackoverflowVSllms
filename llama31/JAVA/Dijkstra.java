import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// Dijkstra's algorithm implementation for finding the shortest path
public class Dijkstra {
    public static List<Node> shortestPath(Graph graph, Node start, Node end) {
        // Initialize distances and previous nodes
        Map<Node, Integer> distances = new HashMap<>();
        Map<Node, Node> previous = new HashMap<>();

        // Initialize priority queue
        PriorityQueue<Node> queue = new PriorityQueue<>();

        // Add start node to queue
        queue.add(start);

        // Initialize distances for all nodes
        for (Node node : graph.getNodes()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            // Update distances and previous nodes
            for (Edge edge : graph.getEdges(currentNode)) {
                int distance = distances.get(currentNode) + edge.getWeight();
                if (distance < distances.get(edge.getDestination())) {
                    distances.put(edge.getDestination(), distance);
                    previous.put(edge.getDestination(), currentNode);
                    queue.add(edge.getDestination());
                }
            }
        }

        // Build shortest path
        List<Node> path = new ArrayList<>();
        Node currentNode = end;
        while (currentNode != start) {
            path.add(0, currentNode);
            currentNode = previous.get(currentNode);
        }
        path.add(0, start);

        return path;
    }

    public static void main(String[] args) {
    }
}

class Node implements Comparable<Node> {
    private String name;

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Node other) {
        return name.compareTo(other.name);
    }
}

class Edge {
    private Node source;
    private Node destination;
    private int weight;

    public Edge(Node source, Node destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public Node getSource() {
        return source;
    }

    public Node getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }
}

class Graph {
    private List<Node> nodes;
    private Map<Node, List<Edge>> edges;

    public Graph() {
        nodes = new ArrayList<>();
        edges = new HashMap<>();
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public void addEdge(Edge edge) {
        if (!edges.containsKey(edge.getSource())) {
            edges.put(edge.getSource(), new ArrayList<>());
        }
        edges.get(edge.getSource()).add(edge);
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public List<Edge> getEdges(Node node) {
        return edges.get(node);
    }
}