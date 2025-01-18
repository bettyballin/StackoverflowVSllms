import java.util.ArrayList;
import java.util.LinkedList;

public class GraphPathFinder {
    private final int V; // Number of vertices or nodes.
    private LinkedList<Integer> adj[]; // Adjacency List representation.
    ArrayList<String> result; // Store the paths discovered on reaching N length.
    private boolean[] visited; // Keep track of traversed nodes to avoid cycles and duplicates.

    public GraphPathFinder(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
        result = new ArrayList<>();
        visited = new boolean[V];
    }

    void DFS(int v, String str) {
        if (str.length() == V - 1) {
            result.add(str); // A valid path discovered - store it.
            return;
        }
        visited[v] = true;
        for (int i : adj[v]) {
            DFS(i, str + (char) ('0' + v));
        }
        // Once all edges of current node are traversed, mark unvisited to allow future paths from this point.
        visited[v] = false;
    }

    public static void main(String[] args) {
    }
}