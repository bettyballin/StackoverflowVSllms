/*
 * Decompiled with CFR 0.152.
 */
public class RedBlackTree {
    private Node root;

    public void insert(double d) {
        Node node = new Node(d);
        if (this.root == null) {
            this.root = node;
        } else {
            this.insertNode(this.root, node);
        }
    }

    private void insertNode(Node node, Node node2) {
        if (node2.key < node.key) {
            if (node.left == null) {
                node.left = node2;
                node2.parent = node;
            } else {
                this.insertNode(node.left, node2);
            }
        } else if (node.right == null) {
            node.right = node2;
            node2.parent = node;
        } else {
            this.insertNode(node.right, node2);
        }
        this.balanceTree(node2);
    }

    private void balanceTree(Node node) {
    }

    public static void main(String[] stringArray) {
    }

    private static class Node {
        double key;
        Node left;
        Node right;
        Node parent;
        boolean isRed;

        Node(double d) {
            this.key = d;
            this.isRed = true;
        }
    }
}
