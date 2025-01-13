import java.lang.String;

class UnionFind {
    private int[] parent;

    public UnionFind(int n) {
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

    public boolean hasCycle(int[][] edges) {
        for (int[] edge : edges) {
            if (find(edge[0]) == find(edge[1])) {
                return true;
            }
            union(edge[0], edge[1]);
        }
        return false;
    }
}

public class CycleDetector {
    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
        UnionFind uf = new UnionFind(3);

        if (uf.hasCycle(edges)) {
            System.out.println("Cycle detected");
        } else {
            System.out.println("No cycle detected");
        }
    }
}