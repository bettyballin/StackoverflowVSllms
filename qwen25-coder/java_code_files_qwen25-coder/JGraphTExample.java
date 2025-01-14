import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

public class JGraphTExample {
    public static void main(String[] args) {
        // Create new directed weighted graph
        Graph<String, DefaultWeightedEdge> graph = 
            new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);

        // Add vertices and edges with weights
        String v1 = "A";
        String v2 = "B";
        String v3 = "C";
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        
        DefaultWeightedEdge e1 = graph.addEdge(v1, v2);
        graph.setEdgeWeight(e1, 5.0);
        DefaultWeightedEdge e2 = graph.addEdge(v2, v3);
        graph.setEdgeWeight(e2, 3.0);

        // Compute shortest path from A to C
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraAlg = 
            new DijkstraShortestPath<>(graph);
        System.out.println(dijkstraAlg.getPath(v1, v3));
    }
}