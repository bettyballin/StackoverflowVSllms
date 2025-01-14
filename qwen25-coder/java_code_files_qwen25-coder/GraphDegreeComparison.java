import java.util.*;

public class GraphDegreeComparison {

    private Map<Integer, List<Integer>> graph; // Adjacency list representation

    public GraphDegreeComparison() {
        this.graph = new HashMap<>();
    }

    // Add edge to the graph (undirected)
    public void addEdge(int u, int v) {
        graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    }

    // Get degree of a vertex
    private int getDegree(int vertex) {
        return graph.getOrDefault(vertex, Collections.emptyList()).size();
    }

    // Find all vertices with degree smaller than their neighbors
    public Set<Integer> findVerticesWithSmallerDegree() {
        Map<Integer, Integer> degrees = new HashMap<>();
        
        // Calculate degrees for all vertices
        for (int vertex : graph.keySet()) {
            degrees.put(vertex, getDegree(vertex));
        }

        Set<Integer> result = new HashSet<>();

        // Compare each vertex with its neighbors
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            int vertex = entry.getKey();
            int currentDegree = degrees.get(vertex);
            boolean allGreater = true;

            for (int neighbor : entry.getValue()) {
                if (degrees.get(neighbor) <= currentDegree) {
                    allGreater = false;
                    break;
                }
            }

            if (allGreater) {
                result.add(vertex);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        GraphDegreeComparison graph = new GraphDegreeComparison();
        // Example edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);

        Set<Integer> vertices = graph.findVerticesWithSmallerDegree();
        System.out.println("Vertices with degree smaller than their neighbors: " + vertices);
    }
}