import java.util.*;

public class Kruskal {
    public static class Edge implements Comparable<Edge> {
        int u, v, weight;

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(weight, other.weight);
        }
    }

    public static class DisjointSet {
        int[] parent;

        public DisjointSet(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
            }
        }
    }

    public static List<Edge> kruskal(List<Edge> edges, int numVertices) {
        DisjointSet ds = new DisjointSet(numVertices);
        List<Edge> mst = new ArrayList<>();
        Collections.sort(edges);

        for (Edge edge : edges) {
            int u = edge.u;
            int v = edge.v;
            if (ds.find(u) != ds.find(v)) {
                mst.add(edge);
                ds.union(u, v);
            }
        }

        return mst;
    }

    public static void main(String[] args) {
        // Example usage
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 2));
        edges.add(new Edge(0, 3, 6));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(1, 3, 8));
        edges.add(new Edge(1, 4, 5));
        edges.add(new Edge(2, 4, 7));
        edges.add(new Edge(3, 4, 9));

        int numVertices = 5;

        List<Edge> mst = kruskal(edges, numVertices);

        System.out.println("Minimum Spanning Tree:");
        for (Edge edge : mst) {
            System.out.println("u=" + edge.u + ", v=" + edge.v + ", weight=" + edge.weight);
        }
    }
}