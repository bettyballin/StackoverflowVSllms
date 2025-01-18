import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import java.util.*;

public class GraphExample {
    public static void main(String[] args) {
        // Create an empty graph (undirected)
        Graph<String, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);

        // Add vertices and edges to the graph
        String v1 = "v1";
        String v2 = "v2";
        String v3 = "v3";
        String v4 = "v4";
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addEdge(v1, v2);
        graph.addEdge(v2, v3);
        graph.addEdge(v2, v4);

        // Use methods like isConnected(), findPaths() etc.
    }
}