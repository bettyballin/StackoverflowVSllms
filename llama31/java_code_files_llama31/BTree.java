/*
 * Decompiled with CFR 0.152.
 */
class BTree {
    private Node root;
    private int degree;

    public BTree(int n) {
        this.degree = n;
    }

    public void insert(int n) {
        if (this.root == null) {
            this.root = new Node(this, this.degree);
            this.root.keys[0] = n;
            ++this.root.numKeys;
        } else if (this.root.numKeys == 2 * this.degree - 1) {
            Node node = new Node(this, this.degree);
            node.children[0] = this.root;
            this.splitChild(node, 0);
            this.insertNonFull(node, n);
            this.root = node;
        } else {
            this.insertNonFull(this.root, n);
        }
    }

    private void insertNonFull(Node node, int n) {
        if (node.leaf) {
            for (int i = node.numKeys - 1; i >= 0 && n < node.keys[i]; --i) {
                node.keys[i + 1] = node.keys[i];
            }
            node.keys[i + 1] = n;
            ++node.numKeys;
        } else {
            int n2;
            for (n2 = node.numKeys - 1; n2 >= 0 && n < node.keys[n2]; --n2) {
            }
            if (node.children[n2 + 1].numKeys == 2 * this.degree - 1) {
                this.splitChild(node, n2 + 1);
                if (n > node.keys[n2 + 1]) {
                    ++n2;
                }
            }
            this.insertNonFull(node.children[n2 + 1], n);
        }
    }

    private void splitChild(Node node, int n) {
        Node node2;
        Node node3 = node.children[n];
        node.children[n + 1] = node2 = new Node(this, this.degree);
        node.keys[n] = node3.keys[this.degree - 1];
        node2.leaf = node3.leaf;
        System.arraycopy(node3.keys, this.degree, node2.keys, 0, this.degree - 1);
        System.arraycopy(node3.children, this.degree, node2.children, 0, this.degree);
        node3.numKeys = this.degree - 1;
        node2.numKeys = this.degree - 1;
    }

    private class Node {
        int degree;
        int numKeys;
        int[] keys;
        Node[] children;
        boolean leaf;

        Node(BTree bTree, int n) {
            this.degree = n;
            this.numKeys = 0;
            this.keys = new int[2 * n - 1];
            this.children = new Node[2 * n];
            this.leaf = true;
        }
    }
}
