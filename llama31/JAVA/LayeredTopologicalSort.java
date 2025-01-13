import java.util.*;

public class LayeredTopologicalSort {
    public static List<List<Integer>> layeredTopologicalSort(DirectedGraph graph) {
        // Perform standard topological sort
        List<Integer> sortedStudents = topologicalSort(graph);

        // Initialize list of rows
        List<List<Integer>> rows = new ArrayList<>();

        // Iterate through sorted students and assign to rows
        for (Integer student : sortedStudents) {
            boolean added = false;
            for (int i = rows.size() - 1; i >= 0; i--) {
                List<Integer> row = rows.get(i);
                if (row.stream().anyMatch(j -> graph.hasEdge(student, j))) {
                    // Add student to row in front of hated student
                    rows.add(i, Collections.singletonList(student));
                    added = true;
                    break;
                }
            }
            if (!added) {
                // Add student to new row at the end
                rows.add(Collections.singletonList(student));
            }
        }

        return rows;
    }

    public static List<Integer> topologicalSort(DirectedGraph graph) {
        List<Integer> sorted = new ArrayList<>();
        Map<Integer, Integer> inDegree = new HashMap<>();

        // Initialize in-degree map
        for (int vertex : graph.getVertices()) {
            inDegree.put(vertex, graph.getInDegree(vertex));
        }

        // Create queue for vertices with in-degree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int vertex : inDegree.keySet()) {
            if (inDegree.get(vertex) == 0) {
                queue.add(vertex);
            }
        }

        // Perform Kahn's algorithm
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            sorted.add(vertex);
            for (int neighbor : graph.getNeighbors(vertex)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Check for cycles
        if (sorted.size() != graph.getVertices().size()) {
            throw new RuntimeException("Cycle detected in graph");
        }

        return sorted;
    }

    public static class DirectedGraph {
        private Map<Integer, List<Integer>> adjacencyList;
        private Set<Integer> vertices;

        public DirectedGraph() {
            adjacencyList = new HashMap<>();
            vertices = new HashSet<>();
        }

        public void addEdge(int source, int target) {
            vertices.add(source);
            vertices.add(target);
            adjacencyList.computeIfAbsent(source, k -> new ArrayList<>()).add(target);
        }

        public boolean hasEdge(int source, int target) {
            return adjacencyList.containsKey(source) && adjacencyList.get(source).contains(target);
        }

        public Set<Integer> getVertices() {
            return vertices;
        }

        public List<Integer> getNeighbors(int vertex) {
            return adjacencyList.getOrDefault(vertex, Collections.emptyList());
        }

        public int getInDegree(int vertex) {
            int inDegree = 0;
            for (List<Integer> neighbors : adjacencyList.values()) {
                if (neighbors.contains(vertex)) {
                    inDegree++;
                }
            }
            return inDegree;
        }
    }

    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);

        List<List<Integer>> rows = layeredTopologicalSort(graph);
        System.out.println(rows);
    }
}