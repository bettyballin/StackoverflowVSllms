import java.lang.String;
import java.lang.Integer;
public class BellmanFord {
    public static void bellmanFord(int[] distance, int[] predecessor, int[][] graph) {
        int n = distance.length;
        int m = graph.length;

        // Initialize distances and predecessors
        for (int i = 0; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
            predecessor[i] = -1;
        }

        distance[0] = 0; // Distance to source vertex is 0

        // Relax edges repeatedly
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                int u = graph[j][0];
                int v = graph[j][1];
                int weight = graph[j][2];

                if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                    distance[v] = distance[u] + weight;
                    predecessor[v] = u;
                }
            }
        }

        // Check for negative-weight cycles
        for (int i = 0; i < m; i++) {
            int u = graph[i][0];
            int v = graph[i][1];
            int weight = graph[i][2];

            if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                System.out.println("Negative-weight cycle detected");
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 1, 5},
            {0, 2, 4},
            {1, 2, 3},
            {1, 3, 6},
            {2, 3, 2},
            {3, 4, 1}
        };

        int[] distance = new int[5];
        int[] predecessor = new int[5];

        bellmanFord(distance, predecessor, graph);

        System.out.println("Distances:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Vertex " + i + ": " + distance[i]);
        }
    }
}