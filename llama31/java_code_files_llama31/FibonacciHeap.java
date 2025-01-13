/*
 * Decompiled with CFR 0.152.
 */
public class FibonacciHeap {
    private Node root = null;
    private Node minNode = null;
    private int size = 0;

    public void insert(int n) {
        Node node = new Node(n);
        if (this.root == null) {
            this.root = node;
            this.minNode = node;
        } else {
            node.left = this.root.left;
            node.right = this.root;
            this.root.left.right = node;
            this.root.left = node;
            if (node.key < this.minNode.key) {
                this.minNode = node;
            }
        }
        ++this.size;
    }

    public int extractMin() {
        if (this.minNode == null) {
            throw new RuntimeException("Heap is empty");
        }
        int n = this.minNode.key;
        if (this.minNode.child != null) {
            Node node = this.minNode.child;
            while (node != null) {
                Node node2 = node.right;
                node.parent = null;
                node.left = this.root.left;
                node.right = this.root;
                this.root.left.right = node;
                this.root.left = node;
                node = node2;
            }
        }
        this.minNode.left.right = this.minNode.right;
        this.minNode.right.left = this.minNode.left;
        if (this.minNode == this.root) {
            this.root = this.minNode.right;
        }
        this.minNode = null;
        this.consolidate();
        --this.size;
        return n;
    }

    private void consolidate() {
        int n = (int)Math.floor(Math.log(this.size) / Math.log(2.0)) + 2;
        Node[] nodeArray = new Node[n];
        Node[] nodeArray2 = this.root;
        while (nodeArray2 != null) {
            Node[] nodeArray3 = nodeArray2.right;
            int n2 = nodeArray2.degree;
            while (nodeArray[n2] != null) {
                Node[] nodeArray4 = nodeArray[n2];
                if (nodeArray2.key > nodeArray4.key) {
                    Node[] nodeArray5 = nodeArray2;
                    nodeArray2 = nodeArray4;
                    nodeArray4 = nodeArray5;
                }
                nodeArray4.left.right = nodeArray4.right;
                nodeArray4.right.left = nodeArray4.left;
                nodeArray4.parent = nodeArray2;
                nodeArray4.right = nodeArray4;
                nodeArray4.left = nodeArray4;
                if (nodeArray2.child == null) {
                    nodeArray2.child = nodeArray4;
                } else {
                    nodeArray4.left = nodeArray2.child.left;
                    nodeArray4.right = nodeArray2.child;
                    nodeArray2.child.left.right = nodeArray4;
                    nodeArray2.child.left = nodeArray4;
                }
                ++nodeArray2.degree;
                if (nodeArray2.key < this.minNode.key) {
                    this.minNode = nodeArray2;
                }
                nodeArray[n2] = null;
                ++n2;
            }
            nodeArray[n2] = nodeArray2;
            nodeArray2 = nodeArray3;
        }
        this.minNode = null;
        for (Node node : nodeArray) {
            if (node == null || this.minNode != null && node.key >= this.minNode.key) continue;
            this.minNode = node;
        }
    }

    public static void main(String[] stringArray) {
    }

    private static class Node {
        int key;
        Node parent;
        Node child;
        Node left;
        Node right;
        int degree;
        boolean marked;

        public Node(int n) {
            this.key = n;
            this.parent = null;
            this.child = null;
            this.left = null;
            this.right = null;
            this.degree = 0;
            this.marked = false;
        }
    }
}
