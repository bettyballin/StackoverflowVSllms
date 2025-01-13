import java.util.List;
import java.util.ArrayList;

public class GraphCycleDetector_1_1 {
    public boolean hasCycle(List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        boolean[] recursionStack = new boolean[graph.size()];
        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i] && !dfsUtil(graph, i, visited, recursionStack)) {
                return true; // cycle detected
            }
        }
        return false;
    }

    private boolean dfsUtil(List<List<Integer>> graph, int v, boolean[] visited, boolean[] recursionStack) {
        visited[v] = true;
        recursionStack[v] = true;
        for (int neighbor : graph.get(v)) {
            if (!visited[neighbor] && !dfsUtil(graph, neighbor, visited, recursionStack)) {
                return false; // cycle detected
            }
            if (recursionStack[neighbor]) {
                return false; // cycle detected
            }
        }
        recursionStack[v] = false;
        return true;
    }

    public static void main(String[] args) {
        // Example usage:
        GraphCycleDetector_1 detector = new GraphCycleDetector_1();
        List<List<Integer>> graph = new ArrayList<>();
        graph.add(new ArrayList<>());
        graph.get(0).add(1);
        graph.add(new ArrayList<>());
        graph.get(1).add(2);
        graph.add(new ArrayList<>());
        graph.get(2).add(0);
        System.out.println(detector.hasCycle(graph)); // prints: true
    }
}