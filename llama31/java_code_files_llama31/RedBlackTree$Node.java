/*
 * Decompiled with CFR 0.152.
 */
private static class RedBlackTree.Node {
    double key;
    RedBlackTree.Node left;
    RedBlackTree.Node right;
    RedBlackTree.Node parent;
    boolean isRed;

    RedBlackTree.Node(double d) {
        this.key = d;
        this.isRed = true;
    }
}
