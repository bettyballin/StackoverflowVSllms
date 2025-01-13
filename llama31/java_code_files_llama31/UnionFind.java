/*
 * Decompiled with CFR 0.152.
 */
class UnionFind {
    private int[] parent;

    public UnionFind(int n) {
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

    public boolean hasCycle(int[][] nArray) {
        for (int[] nArray2 : nArray) {
            if (this.find(nArray2[0]) == this.find(nArray2[1])) {
                return true;
            }
            this.union(nArray2[0], nArray2[1]);
        }
        return false;
    }
}
