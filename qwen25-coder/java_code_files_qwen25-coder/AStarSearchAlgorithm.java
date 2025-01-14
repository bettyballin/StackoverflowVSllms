import java.util.*;
import java.util.function.Function;

public class AStarSearchAlgorithm extends MapGraph {

    public Optional<List<Node>> aStarSearch(Node start, Node goal) {
        // heuristic function
        Function<Node, Double> h = (Node n) -> n.getHeuristicDistance(goal);

        // priority queue
        PriorityQueue<Node> openSet = new PriorityQueue<>((n1, n2) -> {
            return Double.compare(n1.fScore, n2.fScore);
        });

        MapGraph graph = this;

        start.gScore = 0;
        start.fScore = h.apply(start);
        openSet.add(start);

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();

            if (current == goal) {
                return Optional.of(reconstructPath(goal));
            }

            for (Edge edge : graph.adjacencyList.getOrDefault(current, Collections.emptyList())) {
                double tentativeGScore = current.gScore + edge.weight;

                if (tentativeGScore < edge.target.gScore) {
                    edge.target.cameFrom = current;
                    edge.target.gScore = tentativeGScore;
                    edge.target.fScore = tentativeGScore + h.apply(edge.target);

                    if (!openSet.contains(edge.target)) {
                        openSet.add(edge.target);
                    }
                }
            }
        }

        return Optional.empty();
    }

    private List<Node> reconstructPath(Node current) {
        LinkedList<Node> path = new LinkedList<>();
        while (current != null) {
            path.offerFirst(current);
            current = current.cameFrom;
        }
        return path;
    }

    public static void main(String[] args) {
    }
}

class Node {
    public double gScore = Double.POSITIVE_INFINITY;
    public double fScore = Double.POSITIVE_INFINITY;
    public Node cameFrom = null;

    public double getHeuristicDistance(Node goal) {
        // Placeholder for actual heuristic calculation
        return 0;
    }
}

class Edge {
    public Node target;
    public double weight;

    public Edge(Node target, double weight) {
        this.target = target;
        this.weight = weight;
    }
}

class MapGraph {
    public Map<Node, List<Edge>> adjacencyList = new HashMap<>();

    public void addEdge(Node source, Node target, double weight) {
        adjacencyList.computeIfAbsent(source, k -> new ArrayList<>()).add(new Edge(target, weight));
    }
}