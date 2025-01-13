/*
 * Decompiled with CFR 0.152.
 */
public static class Kruskal.DisjointSet {
    int[] parent;

    public Kruskal.DisjointSet(int n) {
        this.parent = new int[n];
        for (int i = 0; i < n; ++i) {
            this.parent[i] = i;
        }
    }

    public int find(int n) {
        if (this.parent[n] != n) {
            this.parent[n] = this.find(this.parent[n]);
        }
        return this.parent[n];
    }

    public void union(int n, int n2) {
        int n3;
        int n4 = this.find(n);
        if (n4 != (n3 = this.find(n2))) {
            this.parent[n4] = n3;
        }
    }
}
