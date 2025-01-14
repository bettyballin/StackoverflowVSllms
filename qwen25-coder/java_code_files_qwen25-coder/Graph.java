import java.util.*;

public class Graph {
    private final Map<Integer, List<Edge>> adjLists;

    public Graph() {
        this.adjLists = new HashMap<>();
    }

    public void addEdge(int source, int destination, int weight) {
        adjLists.computeIfAbsent(source, k -> new ArrayList<>()).add(new Edge(destination, weight));
    }

    private static class Edge {
        int dest;
        int weight;

        Edge(int destination, int weight) {
            this.dest = destination;
            this.weight = weight;
        }
    }

    public void dijkstra(int startVertex, Map<Integer, Integer> distances, Map<Integer, Integer> previousPaths) {
        PriorityQueue<VertexDistance> pq = new PriorityQueue<>(Comparator.comparingInt(vd -> vd.distance));
        Set<Integer> visited = new HashSet<>();

        distances.put(startVertex, 0);
        pq.add(new VertexDistance(startVertex, 0));

        while (!pq.isEmpty()) {
            VertexDistance current = pq.poll();

            if (visited.contains(current.vertex)) continue;
            visited.add(current.vertex);

            for (Edge neighbor : adjLists.getOrDefault(current.vertex, Collections.emptyList())) {
                int newDist = current.distance + neighbor.weight;

                if (!distances.containsKey(neighbor.dest) || newDist < distances.get(neighbor.dest)) {
                    distances.put(neighbor.dest, newDist);
                    previousPaths.put(neighbor.dest, current.vertex);
                    pq.add(new VertexDistance(neighbor.dest, newDist));
                }
            }
        }
    }

    private static class VertexDistance {
        int vertex;
        int distance;

        VertexDistance(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    public List<Integer> getPath(int start, int end, Map<Integer, Integer> previousPaths) {
        List<Integer> path = new ArrayList<>();
        for (int at = end; at != start && at != -1; at = previousPaths.getOrDefault(at, -1)) {
            path.add(0, at);
        }
        if (!path.isEmpty() || start == end) path.add(0, start);

        return !previousPaths.containsKey(end) ? Collections.emptyList() : path;
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge(1, 2, 7);
        graph.addEdge(1, 3, 9);
        graph.addEdge(1, 6, 14);
        graph.addEdge(2, 3, 10);
        graph.addEdge(2, 4, 15);
        graph.addEdge(3, 4, 11);
        graph.addEdge(3, 6, 2);
        graph.addEdge(4, 5, 6);
        graph.addEdge(5, 6, 9);

        Map<Integer, Integer> distances = new HashMap<>();
        Map<Integer, Integer> previousPaths = new HashMap<>();

        graph.dijkstra(1, distances, previousPaths);

        System.out.println("Distances from vertex 1: " + distances);

        List<Integer> pathFrom1To5 = graph.getPath(1, 5, previousPaths);
        System.out.println("Path from vertex 1 to vertex 5: " + pathFrom1To5);
    }
}