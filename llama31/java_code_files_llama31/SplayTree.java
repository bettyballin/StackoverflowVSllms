/*
 * Decompiled with CFR 0.152.
 */
class SplayTree {
    private Node root;

    SplayTree() {
    }

    public void insert(int n) {
        this.root = this.insert(this.root, n);
    }

    private Node insert(Node node, int n) {
        if (node == null) {
            return new Node(this, n);
        }
        if (n < node.key) {
            node.left = this.insert(node.left, n);
        } else if (n > node.key) {
            node.right = this.insert(node.right, n);
        }
        return this.splay(node, n);
    }

    private Node splay(Node node, int n) {
        if (node == null) {
            return null;
        }
        if (n < node.key) {
            if (node.left != null && n < node.left.key) {
                node.left.left = this.splay(node.left.left, n);
                node = this.rotateRight(node);
            } else if (node.left != null) {
                node.left = this.splay(node.left, n);
            }
            return node.left == null ? node : this.rotateRight(node);
        }
        if (n > node.key) {
            if (node.right != null && n > node.right.key) {
                node.right.right = this.splay(node.right.right, n);
                node = this.rotateLeft(node);
            } else if (node.right != null) {
                node.right = this.splay(node.right, n);
            }
            return node.right == null ? node : this.rotateLeft(node);
        }
        return node;
    }

    private Node rotateRight(Node node) {
        Node node2 = node.left;
        node.left = node2.right;
        node2.right = node;
        return node2;
    }

    private Node rotateLeft(Node node) {
        Node node2 = node.right;
        node.right = node2.left;
        node2.left = node;
        return node2;
    }

    private class Node {
        int key;
        Node left;
        Node right;

        Node(SplayTree splayTree, int n) {
            this.key = n;
        }
    }
}
