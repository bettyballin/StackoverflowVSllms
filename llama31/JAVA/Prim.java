import java.lang.String;
import java.lang.Integer;
import java.util.PriorityQueue;

public class Prim {
    public static void prim(int[][] graph) {
        int V = graph.length;
        boolean[] visited = new boolean[V];
        PriorityQueue<Edge> heap = new PriorityQueue<>();

        // Initialize heap with edges connected to the first vertex
        for (int i = 1; i < V; i++) {
            heap.add(new Edge(0, i, graph[0][i]));
        }

        while (!heap.isEmpty()) {
            Edge e = heap.poll();
            if (!visited[e.v2]) {
                visited[e.v2] = true;
                System.out.println("Added edge: " + e.v1 + " - " + e.v2 + " with weight " + e.weight);

                // Add edges connected to the newly visited vertex to the heap
                for (int i = 0; i < V; i++) {
                    if (!visited[i] && graph[e.v2][i] != 0) {
                        heap.add(new Edge(e.v2, i, graph[e.v2][i]));
                    }
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int v1, v2, weight;

        public Edge(int v1, int v2, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }

        public int compareTo(Edge other) {
            return Integer.compare(weight, other.weight);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };

        prim(graph);
    }
}