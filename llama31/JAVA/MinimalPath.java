import java.util.*;

public class MinimalPath {
    public static List<String> bfs(Graph graph, String start, String end) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Map<String, String> parent = new HashMap<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String node = queue.poll();

            if (node.equals(end)) {
                List<String> path = new ArrayList<>();
                while (node != null) {
                    path.add(node);
                    node = parent.get(node);
                }
                Collections.reverse(path);
                return path;
            }

            for (String neighbor : graph.getNeighbors(node)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    parent.put(neighbor, node);
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");

        List<String> path = bfs(graph, "A", "C");
        System.out.println(path); // prints [A, B, C]
    }
}

class Graph {
    private Map<String, List<String>> edges = new HashMap<>();

    public void addEdge(String node1, String node2) {
        edges.computeIfAbsent(node1, k -> new ArrayList<>()).add(node2);
        edges.computeIfAbsent(node2, k -> new ArrayList<>()).add(node1);
    }

    public List<String> getNeighbors(String node) {
        return edges.get(node);
    }
}