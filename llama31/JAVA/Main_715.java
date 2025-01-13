import java.lang.String;
public class Main_715 {
    public static boolean isCyclicUtil(int v, boolean[] visited, int[] parent, int[][] graph) {
        visited[v] = true;
        for (int i = 0; i < graph[v].length; i++) {
            int neighbor = graph[v][i];
            if (!visited[neighbor]) {
                parent[neighbor] = v;
                if (isCyclicUtil(neighbor, visited, parent, graph))
                    return true;
            } else if (parent[v] != neighbor)
                return true;
        }
        return false;
    }

    public static boolean isCyclic(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        int[] parent = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            visited[i] = false;
            parent[i] = -1;
        }
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, parent, graph))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {0, 2, 3}, {0, 1, 3}, {1, 2}};
        System.out.println(isCyclic(graph)); // prints: true
    }
}