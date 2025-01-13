/*
 * Decompiled with CFR 0.152.
 */
class SegmentTree {
    private int[] tree;
    private int n;

    public SegmentTree(int[] nArray) {
        this.n = nArray.length;
        this.tree = new int[4 * this.n];
        this.buildTree(nArray, 0, 0, this.n - 1);
    }

    private void buildTree(int[] nArray, int n, int n2, int n3) {
        if (n2 == n3) {
            this.tree[n] = nArray[n2];
        } else {
            int n4 = (n2 + n3) / 2;
            this.buildTree(nArray, 2 * n + 1, n2, n4);
            this.buildTree(nArray, 2 * n + 2, n4 + 1, n3);
            this.tree[n] = Math.min(this.tree[2 * n + 1], this.tree[2 * n + 2]);
        }
    }

    public int query(int n, int n2) {
        return this.query(0, 0, this.n - 1, n, n2);
    }

    private int query(int n, int n2, int n3, int n4, int n5) {
        if (n4 > n3 || n5 < n2) {
            return Integer.MAX_VALUE;
        }
        if (n4 <= n2 && n5 >= n3) {
            return this.tree[n];
        }
        int n6 = (n2 + n3) / 2;
        return Math.min(this.query(2 * n + 1, n2, n6, n4, n5), this.query(2 * n + 2, n6 + 1, n3, n4, n5));
    }
}
