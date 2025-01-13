/*
 * Decompiled with CFR 0.152.
 */
private class BTree.Node {
    int degree;
    int numKeys;
    int[] keys;
    BTree.Node[] children;
    boolean leaf;

    BTree.Node(BTree bTree, int n) {
        this.degree = n;
        this.numKeys = 0;
        this.keys = new int[2 * n - 1];
        this.children = new BTree.Node[2 * n];
        this.leaf = true;
    }
}
