import java.lang.String;
public class CriticalPath {
    public static int[] computeCriticalPath(int[][] graph, int[] weights) {
        int n = graph.length;
        int[] distance = new int[n];
        int[] predecessor = new int[n];

        // Initialize distance and predecessor arrays
        for (int i = 0; i < n; i++) {
            distance[i] = weights[i];
            predecessor[i] = -1;
        }

        // Perform topological sort
        int[] topoOrder = topologicalSort(graph);

        // Compute critical path
        for (int i = 0; i < n; i++) {
            int node = topoOrder[i];
            for (int j = 0; j < graph[node].length; j++) {
                int neighbor = graph[node][j];
                int newDistance = distance[node] + weights[neighbor];
                if (newDistance > distance[neighbor]) {
                    distance[neighbor] = newDistance;
                    predecessor[neighbor] = node;
                }
            }
        }

        // Reconstruct critical path
        int[] criticalPath = new int[n];
        int idx = 0;
        int currentNode = n - 1;
        while (currentNode >= 0) {
            criticalPath[idx++] = currentNode;
            currentNode = predecessor[currentNode];
        }

        return criticalPath;
    }

    public static int[] topologicalSort(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n];
        int[] order = new int[n];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(graph, i, visited, order, idx);
            }
        }

        return order;
    }

    private static void dfs(int[][] graph, int node, int[] visited, int[] order, int idx) {
        visited[node] = 1;
        for (int i = 0; i < graph[node].length; i++) {
            int neighbor = graph[node][i];
            if (visited[neighbor] == 0) {
                dfs(graph, neighbor, visited, order, idx);
            }
        }
        order[idx++] = node;
    }

	public static void main(String[] args) {
	}
}