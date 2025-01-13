import java.lang.String;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

public class SimpleGraph {
    public static void main(String[] args) {
        Graph graph = new SingleGraph("Simple Graph");

        // Add nodes
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");

        // Add edges
        graph.addEdge("AB", "A", "B");
        graph.addEdge("BC", "B", "C");
        graph.addEdge("CA", "C", "A");

        // Check if two nodes are connected
        System.out.println(graph.getNode("A").hasEdgeBetween("B")); // prints: true

        // Find all paths between two nodes
        graph.getNode("A").getEachEdge().forEach(edge -> {
            System.out.println(edge.getId()); // prints: AB, CA
        });
    }
}