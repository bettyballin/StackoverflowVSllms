import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.alg.spanning.KruskalMinimumSpanningTree;

public class GraphExample {
    public static void main(String[] args) {
        // Create a new directed graph
        Graph<String, DefaultEdge> graph = new DefaultDirectedGraph<>(DefaultEdge.class);

        // Add vertices and edges
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("C", "A");

        // Compute the minimum spanning tree
        KruskalMinimumSpanningTree<String, DefaultEdge> mst = new KruskalMinimumSpanningTree<>(graph);
        Graph<String, DefaultEdge> minimumSpanningTree = mst.getSpanningTree();

        // Print the minimum spanning tree
        System.out.println(minimumSpanningTree);
    }
}