/*
 * Decompiled with CFR 0.152.
 */
private static class FibonacciHeap.Node {
    int key;
    FibonacciHeap.Node parent;
    FibonacciHeap.Node child;
    FibonacciHeap.Node left;
    FibonacciHeap.Node right;
    int degree;
    boolean marked;

    public FibonacciHeap.Node(int n) {
        this.key = n;
        this.parent = null;
        this.child = null;
        this.left = null;
        this.right = null;
        this.degree = 0;
        this.marked = false;
    }
}
