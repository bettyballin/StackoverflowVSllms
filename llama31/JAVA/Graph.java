import java.util.*;

public class Graph {
    private Map<Integer, List<Integer>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addEdge(int from, int to) {
        adjacencyList.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
        adjacencyList.computeIfAbsent(to, k -> new ArrayList<>()).add(from); // for undirected graph
    }

    public boolean hasPath(int from, int to) {
        if (!adjacencyList.containsKey(from) || !adjacencyList.containsKey(to)) {
            return false;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(from);
        Set<Integer> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == to) {
                return true;
            }
            visited.add(node);

            for (int neighbor : adjacencyList.get(node)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge(1, 5);
        graph.addEdge(3, 7);
        graph.addEdge(5, 6);
        graph.addEdge(2, 6);

        System.out.println(graph.hasPath(1, 5)); // true
        System.out.println(graph.hasPath(5, 2)); // true
        System.out.println(graph.hasPath(1, 7)); // false
        System.out.println(graph.hasPath(7, 4)); // false
    }
}