import java.util.*;

class Pair {
    int v;
    int weight;

    Pair(int v, int weight) {
        this.v = v;
        this.weight = weight;
    }
}

class Graph { // Directed acyclic graph using adjacency lists
    int V;
    int dist[]; // V is total number of vertices in graph and dist[] as described
    List<List<Pair>> edges; // Each vertex stores a list of its outgoing edges.
    List<Integer> topologicalOrder; // Stores the topological order of vertices.

    Graph(int V) {
        this.V = V;
        dist = new int[V];
        edges = new ArrayList<>();
        for (int i = 0; i < V; ++i) {
            edges.add(new ArrayList<Pair>());
            dist[i] = 0;
        }
        topologicalOrder = new ArrayList<>();
    }

    void addEdge(int u, int v, int weight) { // Method to add an edge between vertices with corresponding weight.
        edges.get(u).add(new Pair(v, weight));
    }

    void topoSortUtil(int v, boolean visited[], Stack<Integer> stack) {
        // Mark the current node as visited.
        visited[v] = true;

        // Recur for all the vertices adjacent to this vertex.
        for (Pair pair : edges.get(v)) {
            if (!visited[pair.v]) {
                topoSortUtil(pair.v, visited, stack);
            }
        }

        // Push current vertex to stack which stores the result.
        stack.push(v);
    }

    void topoSort() {
        Stack<Integer> stack = new Stack<Integer>();

        // Mark all the vertices as not visited.
        boolean visited[] = new boolean[V];

        // Call the recursive helper function to store Topological Sort starting from all vertices one by one.
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topoSortUtil(i, visited, stack);
            }
        }

        // Store vertices in reverse order of their finishing times.
        while (!stack.empty()) {
            topologicalOrder.add(stack.pop());
        }
    }

    long criticalPath() {
        topoSort(); // Perform DFS to determine reverse order of all vertices.

        // From start of the list, traverse to the end.
        for (int i = 0; i < topologicalOrder.size(); ++i) {
            int u = topologicalOrder.get(i);

            // Traverse every adjacent vertex 'v' from current vertex 'u'.
            for (Pair uv : edges.get(u)) {
                int v = uv.v;
                int weight = uv.weight;
                dist[v] = Math.max(dist[v], dist[u] + weight); // Update dist[] holding path lengths dynamically.
            }
        }

        // Returns the maximum length recorded which defines our final answer - criticalPath.
        int max = dist[0];
        for (int i = 1; i < V; i++) {
            if (dist[i] > max) {
                max = dist[i];
            }
        }

        return max;
    }
}