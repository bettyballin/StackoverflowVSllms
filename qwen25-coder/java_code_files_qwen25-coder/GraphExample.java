import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;

import java.util.List;

public class GraphExample {
    public static void main(String[] args) {
        // Create a new directed graph
        Graph<String, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);

        // Add vertices
        String node1 = "Node 1";
        String node2 = "Node 2";
        String node3 = "Node 3";

        graph.addVertex(node1);
        graph.addVertex(node2);
        graph.addVertex(node3);

        // Add edges to connect the nodes
        graph.addEdge(node1, node2);
        graph.addEdge(node2, node3);

        // Check if two nodes are connected via direct edge
        boolean isConnected = graph.containsEdge(node1, node2);
        System.out.println("Is " + node1 + " directly connected to " + node2 + "? " + isConnected);

        // Find the shortest path between two nodes using Dijkstra's algorithm
        List<String> shortestPath = new DijkstraShortestPath<>(graph).getPath(node1, node3).getVertexList();
        System.out.println("Shortest path from " + node1 + " to " + node3 + ": " + shortestPath);
    }
}