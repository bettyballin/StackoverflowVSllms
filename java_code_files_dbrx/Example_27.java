import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultDirectedGraph;

public class Example_27 {
    public static void main(String[] args){
        Graph<Integer, DefaultEdge> g = new DefaultDirectedGraph<>(DefaultEdge.class);
        g.addVertex(1); 	// Addition of vertex
        System.out.println(g); // Print graph
   }
}