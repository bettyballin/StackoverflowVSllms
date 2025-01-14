import java.util.*;

public class GraphTraversal {

    public static boolean hasPathLengthAtMostNOver100(Graph G, Node s, Node t, int n) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        Map<Node, Integer> distanceFromS = new HashMap<>();

        queue.add(s);
        visited.add(s);
        distanceFromS.put(s, 0);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.equals(t)) return true;

            for (Node neighbor : G.getNeighbors(current)) {
                if (!visited.contains(neighbor)) {
                    int distance = distanceFromS.get(current) + 1;
                    if (distance <= n / 100) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                        distanceFromS.put(neighbor, distance);
                    }
                }
            }
        }
        return false;
    }

    // Definition of Graph interface
    public interface Graph {
        List<Node> getNeighbors(Node node);
    }

    // Definition of Node class
    public static class Node {
        private int id;

        public Node(int id) {
            this.id = id;
        }

        // Overriding equals and hashCode for correct comparisons in HashSet and HashMap
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Node)) return false;
            Node other = (Node) obj;
            return this.id == other.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }
}