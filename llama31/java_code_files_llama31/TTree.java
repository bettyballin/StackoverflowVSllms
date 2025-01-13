/*
 * Decompiled with CFR 0.152.
 */
class TTree {
    private Node root;

    TTree() {
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
        return this.balance(node);
    }

    private Node balance(Node node) {
        if (node == null) {
            return null;
        }
        int n = this.getBalanceFactor(node);
        if (n > 1) {
            if (this.getBalanceFactor(node.left) >= 0) {
                node = this.rotateRight(node);
            } else {
                node.left = this.rotateLeft(node.left);
                node = this.rotateRight(node);
            }
        } else if (n < -1) {
            if (this.getBalanceFactor(node.right) <= 0) {
                node = this.rotateLeft(node);
            } else {
                node.right = this.rotateRight(node.right);
                node = this.rotateLeft(node);
            }
        }
        return node;
    }

    private int getBalanceFactor(Node node) {
        return this.getHeight(node.left) - this.getHeight(node.right);
    }

    private int getHeight(Node node) {
        return node == null ? 0 : 1 + Math.max(this.getHeight(node.left), this.getHeight(node.right));
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

    public static void main(String[] stringArray) {
        SplayTree splayTree = new SplayTree();
        RedBlackTree redBlackTree = new RedBlackTree();
        AVLTree aVLTree = new AVLTree();
        BTree bTree = new BTree(3);
        TTree tTree = new TTree();
        splayTree.insert(10);
        splayTree.insert(20);
        splayTree.insert(30);
        redBlackTree.insert(10);
        redBlackTree.insert(20);
        redBlackTree.insert(30);
        aVLTree.insert(10);
        aVLTree.insert(20);
        aVLTree.insert(30);
        bTree.insert(10);
        bTree.insert(20);
        bTree.insert(30);
        tTree.insert(10);
        tTree.insert(20);
        tTree.insert(30);
    }

    private class Node {
        int key;
        Node left;
        Node right;

        Node(TTree tTree, int n) {
            this.key = n;
        }
    }
}
