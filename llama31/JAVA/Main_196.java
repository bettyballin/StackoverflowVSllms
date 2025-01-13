import java.util.Arrays;
import java.util.List;

class Edge implements Comparable<Edge> {
    int source;
    int destination;
    int weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }

    @Override
    public String toString() {
        return "(" + source + ", " + destination + ", " + weight + ")";
    }
}

class Kruskal {
    public static List<Edge> kruskal(List<Edge> edges, int vertices) {
        edges.sort(Edge::compareTo);
        int[] parent = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
        }

        List<Edge> mst = new java.util.ArrayList<>();

        for (Edge edge : edges) {
            if (find(parent, edge.source) != find(parent, edge.destination)) {
                union(parent, edge.source, edge.destination);
                mst.add(edge);
            }
        }

        return mst;
    }

    private static int find(int[] parent, int vertex) {
        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent, parent[vertex]);
        }
        return parent[vertex];
    }

    private static void union(int[] parent, int vertex1, int vertex2) {
        int root1 = find(parent, vertex1);
        int root2 = find(parent, vertex2);
        parent[root1] = root2;
    }
}

public class Main_196 {
    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(
            new Edge(0, 1, 2),
            new Edge(0, 2, 3),
            new Edge(1, 2, 1),
            new Edge(1, 3, 4),
            new Edge(2, 3, 2)
        );

        List<Edge> mst = Kruskal.kruskal(edges, 4);
        System.out.println(mst); // prints the edges in the minimum spanning tree
    }
}