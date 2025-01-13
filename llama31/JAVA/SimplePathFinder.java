import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SimplePathFinder {
    private static class Graph {
        private final Map<String, List<String>> adjacencyList;

        public Graph() {
            adjacencyList = new HashMap<>();
        }

        public void addEdge(String vertex1, String vertex2) {
            adjacencyList.computeIfAbsent(vertex1, k -> new ArrayList<>()).add(vertex2);
            adjacencyList.computeIfAbsent(vertex2, k -> new ArrayList<>()).add(vertex1); // undirected graph
        }

        public List<List<String>> findSimplePaths(String start, String end) {
            List<List<String>> simplePaths = new ArrayList<>();
            Set<String> visited = new HashSet<>();
            List<String> currentPath = new ArrayList<>();

            dfs(start, end, visited, currentPath, simplePaths);

            return simplePaths;
        }

        private void dfs(String currentVertex, String endVertex, Set<String> visited, List<String> currentPath, List<List<String>> simplePaths) {
            visited.add(currentVertex);
            currentPath.add(currentVertex);

            if (currentVertex.equals(endVertex)) {
                simplePaths.add(new ArrayList<>(currentPath));
            } else {
                for (String neighbor : adjacencyList.get(currentVertex)) {
                    if (!visited.contains(neighbor)) {
                        dfs(neighbor, endVertex, visited, currentPath, simplePaths);
                    }
                }
            }

            visited.remove(currentVertex);
            currentPath.remove(currentPath.size() - 1);
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("B", "E");
        graph.addEdge("B", "F");
        graph.addEdge("C", "E");
        graph.addEdge("C", "F");
        graph.addEdge("D", "B");
        graph.addEdge("E", "C");
        graph.addEdge("E", "F");
        graph.addEdge("F", "B");
        graph.addEdge("F", "C");
        graph.addEdge("F", "E");

        List<List<String>> simplePaths = graph.findSimplePaths("B", "E");

        for (List<String> path : simplePaths) {
            System.out.println(String.join(" -> ", path));
        }
    }
}