import java.util.*;

// Define your Thing class with distance calculation
class Thing {
    // Let's give each Thing an id and a method to compute distance to another Thing
    int id;

    public Thing(int id) {
        this.id = id;
    }

    // For demonstration purposes, define a distance function
    // Here, we can just return the absolute difference of ids
    public double distanceTo(Thing other) {
        return Math.abs(this.id - other.id);
    }
}

public class HierarchicalClustering {

    public static List<Set<Thing>> hierarchicalCluster(int numClusters, List<Thing> things) {
        ArrayList<ClusterNode> nodes = new ArrayList<>();

        for (Thing t : things) {
            ClusterNode n = new ClusterNode();
            n.things.add(t);
            nodes.add(n);
        }

        // Use a priority queue to get the smallest distance pair by default
        PriorityQueue<ClusterEdge> pq = new PriorityQueue<>(Comparator.comparingDouble(c -> c.distance));

        for (int i = 0; i < nodes.size(); ++i) {
            ClusterNode x = nodes.get(i);

            // Populate the priority queue with edges between clusters
            for (int j = i + 1; j < nodes.size(); ++j) {
                pq.offer(new ClusterEdge(x, nodes.get(j)));
            }
        }

        while (nodes.size() > numClusters) {
            if (pq.isEmpty()) {
                break;
            }
            ClusterEdge smallest = pq.poll(); // Get the cluster edge with the shortest distance
            mergeNodes(smallest, nodes, pq); // Merge those clusters to form a new node
        }

        List<Set<Thing>> result = new ArrayList<>();

        nodes.forEach(n -> {
            if (n.things != null) result.add(new HashSet<>(n.things));
        });

        return result;
    }

    static void mergeNodes(ClusterEdge edge, List<ClusterNode> nodes, PriorityQueue<ClusterEdge> pq) {
        ClusterNode a = edge.x;
        ClusterNode b = edge.y;

        // Merge b into a
        a.things.addAll(b.things);

        // Remove b from nodes
        nodes.remove(b);

        // Remove obsolete edges involving b from pq
        pq.removeIf(e -> e.x == b || e.y == b);

        // Add new edges between a and other nodes
        for (ClusterNode other : nodes) {
            if (other != a) {
                pq.offer(new ClusterEdge(a, other));
            }
        }
    }

    static double distBetweenClusters(ClusterNode a, ClusterNode b) {
        // Define distance as minimum distance between any pair of Things from the clusters
        double minDist = Double.POSITIVE_INFINITY;
        for (Thing ta : a.things) {
            for (Thing tb : b.things) {
                double d = ta.distanceTo(tb);
                minDist = Math.min(minDist, d);
            }
        }
        return minDist;
    }

    static class ClusterEdge { // Pair that stores the distance between two clusters and references to clusters
        double distance;
        final ClusterNode x, y;

        public ClusterEdge(ClusterNode a, ClusterNode b) {
            this.x = a;
            this.y = b;
            distance = distBetweenClusters(a, b); // Calculate the average linkage distance (if you prefer)
        }
    }

    static class ClusterNode { // Stores the current Thing objects and parent node if exists
        final List<Thing> things = new ArrayList<>();  // This would be a list of "smells" in your example
        ClusterNode parent = null;

        private double distToParent() {
            if (parent != null) {
                double minDist = Double.POSITIVE_INFINITY;
                for (Thing t : things) {
                    for (Thing pt : parent.things) {
                        double d = t.distanceTo(pt);
                        minDist = Math.min(minDist, d);
                    }
                }
                return minDist;
            }
            return Double.POSITIVE_INFINITY;
        }
    }

    public static void main(String[] args) {
        // Example usage
        List<Thing> things = new ArrayList<>();
        things.add(new Thing(1));
        things.add(new Thing(2));
        things.add(new Thing(3));
        things.add(new Thing(10));

        List<Set<Thing>> clusters = hierarchicalCluster(2, things);

        for (Set<Thing> cluster : clusters) {
            System.out.print("Cluster: ");
            for (Thing t : cluster) {
                System.out.print(t.id + " ");
            }
            System.out.println();
        }
    }
}