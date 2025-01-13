/*
 * Decompiled with CFR 0.152.
 */
private static class BKTree.Node {
    int key;
    BKTree.Node[] children;

    public BKTree.Node(int n) {
        this.key = n;
        this.children = new BKTree.Node[10];
    }
}
