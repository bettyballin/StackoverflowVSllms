import java.lang.String;

public class GraphUtil {
    public static boolean[][] transitiveClosure(boolean[][] graph) {
        int n = graph.length;
        boolean[][] closure = new boolean[n][n];

        // Initialize the closure matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                closure[i][j] = graph[i][j];
            }
        }

        // Compute the transitive closure
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    closure[i][j] |= closure[i][k] && closure[k][j];
                }
            }
        }

        return closure;
    }

    public static void main(String[] args) {
        boolean[][] graph = {
            {true, false, false},
            {false, true, false},
            {false, false, true}
        };

        boolean[][] closure = transitiveClosure(graph);

        // Print the transitive closure
        for (int i = 0; i < closure.length; i++) {
            for (int j = 0; j < closure.length; j++) {
                System.out.print(closure[i][j] + " ");
            }
            System.out.println();
        }
    }
}