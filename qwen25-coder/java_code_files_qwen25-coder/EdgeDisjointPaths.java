import java.util.*;

public class EdgeDisjointPaths {

    static class Graph {
        int[][] capacity;
        List<Integer>[] adj;
        int n; // number of nodes

        public Graph(int n) {
            this.n = n;
            capacity = new int[n][n];
            adj = new List[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new ArrayList<>();
            }
        }
        
        public void addEdge(int u, int v, int cap) {
            capacity[u][v] = cap;
            adj[u].add(v);
            adj[v].add(u); // Add reverse edge for residual graph
        }
        
        public List<Integer> getNeighbors(int u) {
            return adj[u];
        }
    }

    boolean hasTwoEdgeDisjointPaths(Graph G, int s, int t) {
        Graph residual = createResidualGraph(G);
        
        int flow = 0;
        Map<Integer, Integer> parent = new HashMap<>();

        while (hasAugmentingPath(residual, s, t, parent)) {
            int path_flow = Integer.MAX_VALUE;
            
            // Find minimum capacity along the path
            for (int v = t; v != s;) {
                int u = parent.get(v);
                path_flow = Math.min(path_flow, residual.capacity[u][v]);
                v = u;
            }
            
            // update residual capacities of the edges and reverse edges along the path
            for (int v = t; v != s;) {
                int u = parent.get(v);
                
                residual.capacity[u][v] -= path_flow;
                residual.capacity[v][u] += path_flow;
                
                v = u;
            }
            
            flow += path_flow;
        }
        
        return flow >= 2;
    }
    
    // Function to check if a path exists in the residual graph
    boolean hasAugmentingPath(Graph residual, int s, int t, Map<Integer, Integer> parent) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        
        visited.add(s);
        queue.add(s);
        
        parent.clear();

        while (!queue.isEmpty()) {
            int u = queue.poll();
            
            for (int v : residual.getNeighbors(u)) {
                if (residual.capacity[u][v] > 0 && !visited.contains(v)) {
                    visited.add(v);
                    parent.put(v, u);
                    
                    if (v == t) return true;
                    
                    queue.add(v);
                }
            }
        }
        
        return false;
    }

    Graph createResidualGraph(Graph G) {
        Graph residual = new Graph(G.n);
        for (int u = 0; u < G.n; u++) {
            for (int v : G.getNeighbors(u)) {
                residual.capacity[u][v] = G.capacity[u][v];
                residual.capacity[v][u] = 0; // Initialize reverse capacities to 0
                if (G.capacity[u][v] > 0) {
                    residual.adj[u].add(v);
                    residual.adj[v].add(u);
                }
            }
        }
        return residual;
    }

    // Example usage
    public static void main(String[] args) {
        EdgeDisjointPaths edp = new EdgeDisjointPaths();
        int n = 4; // Number of nodes
        Graph G = new Graph(n);
        // Add edges (example graph)
        G.addEdge(0, 1, 1);
        G.addEdge(1, 2, 1);
        G.addEdge(2, 3, 1);
        G.addEdge(0, 2, 1);
        G.addEdge(1, 3, 1);

        int s = 0; // Source node
        int t = 3; // Sink node

        boolean result = edp.hasTwoEdgeDisjointPaths(G, s, t);
        System.out.println("Has two edge-disjoint paths: " + result);
    }
}