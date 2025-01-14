import java.util.*;

public class CriticalPath {
    static class Node {
        String name;
        int weight;
        List<Node> children;

        public Node(String name, int weight) {
            this.name = name;
            this.weight = weight;
            this.children = new ArrayList<>();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return Objects.equals(name, node.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    public static void main(String[] args) {
        // Create nodes
        Node A = new Node("A", 3);
        Node B = new Node("B", 4);
        Node D = new Node("D", 7);
        Node E = new Node("E", 2);
        Node F = new Node("F", 3);

        // Create directed acyclic graph
        A.children.add(B);
        A.children.add(D);
        B.children.add(E);
        B.children.add(F);

        Map<Node, Integer> nodeWeights = topologicalSortAndCriticalPath(A);
        
        // Find the critical path end node, which has the maximum weight in nodeWeights
        Node criticalEndNode = null;
        int maxWeight = -1;
        for (Map.Entry<Node, Integer> entry : nodeWeights.entrySet()) {
            if (entry.getValue() > maxWeight) {
                maxWeight = entry.getValue();
                criticalEndNode = entry.getKey();
            }
        }

        // Reconstruct the critical path
        List<String> criticalPath = new ArrayList<>();
        reconstructCriticalPath(criticalEndNode, nodeWeights, criticalPath);

        // Print the critical path and its total weight
        Collections.reverse(criticalPath);
        System.out.println("Critical Path: " + String.join(" -> ", criticalPath));
        System.out.println("Total Weight: " + maxWeight);
    }

    private static Map<Node, Integer> topologicalSortAndCriticalPath(Node start) {
        Map<Node, List<Node>> adjList = new HashMap<>();
        Map<Node, Integer> inDegree = new HashMap<>();
        Map<Node, Integer> nodeWeights = new HashMap<>();

        prepareGraph(start, adjList, inDegree, nodeWeights);

        // Queue for topological sort
        Queue<Node> queue = new LinkedList<>();
        for (Map.Entry<Node, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            nodeWeights.put(current, nodeWeights.getOrDefault(current, 0) + current.weight);
            for (Node neighbor : adjList.getOrDefault(current, new ArrayList<>())) {
                int newWeight = nodeWeights.get(current) + neighbor.weight;
                if (newWeight > nodeWeights.getOrDefault(neighbor, 0)) {
                    nodeWeights.put(neighbor, newWeight);
                }
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return nodeWeights;
    }

    private static void prepareGraph(Node start, Map<Node, List<Node>> adjList, Map<Node, Integer> inDegree, Map<Node, Integer> nodeWeights) {
        if (!inDegree.containsKey(start)) {
            inDegree.put(start, 0);
            nodeWeights.put(start, 0);
            for (Node child : start.children) {
                adjList.computeIfAbsent(start, k -> new ArrayList<>()).add(child);
                inDegree.computeIfAbsent(child, k -> 0);
                inDegree.put(child, inDegree.get(child) + 1);
                prepareGraph(child, adjList, inDegree, nodeWeights);
            }
        }
    }

    private static void reconstructCriticalPath(Node node, Map<Node, Integer> nodeWeights, List<String> path) {
        if (node == null) return;
        path.add(node.name);
        for (Node child : node.children) {
            if (nodeWeights.get(child) == nodeWeights.get(node) - child.weight) {
                reconstructCriticalPath(child, nodeWeights, path);
            }
        }
    }
}