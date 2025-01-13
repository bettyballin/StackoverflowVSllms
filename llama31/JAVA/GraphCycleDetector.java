import java.util.List;
import java.util.ArrayList;

public class GraphCycleDetector {
    public boolean hasCycle(List<List<Integer>> graph) {
        int[] visited = new int[graph.size()];
        for (int i = 0; i < graph.size(); i++) {
            if (visited[i] == 0 && !topologicalSortUtil(graph, i, visited)) {
                return true; // cycle detected
            }
        }
        return false;
    }

    private boolean topologicalSortUtil(List<List<Integer>> graph, int v, int[] visited) {
        visited[v] = 1; // mark as visited
        for (int neighbor : graph.get(v)) {
            if (visited[neighbor] == 1) {
                return false; // cycle detected
            }
            if (visited[neighbor] == 0 && !topologicalSortUtil(graph, neighbor, visited)) {
                return false; // cycle detected
            }
        }
        visited[v] = 2; // mark as done
        return true;
    }

    public static void main(String[] args) {
        GraphCycleDetector detector = new GraphCycleDetector();
        List<List<Integer>> graph = new ArrayList<>();
        // Example usage:
        List<Integer> node1 = new ArrayList<>();
        node1.add(1);
        node1.add(2);
        graph.add(node1);

        List<Integer> node2 = new ArrayList<>();
        node2.add(2);
        graph.add(node2);

        List<Integer> node3 = new ArrayList<>();
        node3.add(0);
        graph.add(node3);

        System.out.println(detector.hasCycle(graph)); // Output: true
    }
}