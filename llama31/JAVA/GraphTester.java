import java.lang.String;

class Graph {
    private int V;
    private int[][] adj;

    public Graph(int vertices) {
        V = vertices;
        adj = new int[vertices][vertices];
    }

    public void addEdge(int u, int v) {
        adj[u][v] = 1;
    }

    public boolean isAcyclic() {
        boolean[] visited = new boolean[V];
        boolean[] stack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, stack)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isCyclicUtil(int v, boolean[] visited, boolean[] stack) {
        if (stack[v]) {
            return true;
        }

        if (visited[v]) {
            return false;
        }

        visited[v] = true;
        stack[v] = true;

        for (int i = 0; i < V; i++) {
            if (adj[v][i] == 1) {
                if (isCyclicUtil(i, visited, stack)) {
                    return true;
                }
            }
        }

        stack[v] = false;
        return false;
    }
}

public class GraphTester {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        if (graph.isAcyclic()) {
            System.out.println("The graph is acyclic");
        } else {
            System.out.println("The graph contains a cycle");
        }
    }
}