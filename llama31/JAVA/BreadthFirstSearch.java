import java.util.*;

public class BreadthFirstSearch {
    static class Graph {
        private Map<Integer, List<Integer>> adjacencyList;

        public Graph() {
            adjacencyList = new HashMap<>();
        }

        public void addEdge(int source, int destination) {
            adjacencyList.computeIfAbsent(source, k -> new ArrayList<>()).add(destination);
            adjacencyList.computeIfAbsent(destination, k -> new ArrayList<>()).add(source);
        }

        public List<List<Integer>> findPaths(int source, int destination) {
            List<List<Integer>> paths = new ArrayList<>();
            Queue<List<Integer>> queue = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();

            queue.offer(Collections.singletonList(source));
            visited.add(source);

            while (!queue.isEmpty()) {
                List<Integer> path = queue.poll();
                int node = path.get(path.size() - 1);

                if (node == destination) {
                    paths.add(path);
                } else {
                    for (int neighbor : adjacencyList.get(node)) {
                        if (!visited.contains(neighbor)) {
                            visited.add(neighbor);
                            List<Integer> newPath = new ArrayList<>(path);
                            newPath.add(neighbor);
                            queue.offer(newPath);
                        }
                    }
                }
            }

            return paths;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge(4, 2);
        graph.addEdge(4, 5);
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);
        graph.addEdge(5, 6);
        graph.addEdge(1, 7);
        graph.addEdge(3, 7);
        graph.addEdge(6, 7);

        List<List<Integer>> paths = graph.findPaths(4, 7);

        for (List<Integer> path : paths) {
            System.out.println(path);
        }
    }
}