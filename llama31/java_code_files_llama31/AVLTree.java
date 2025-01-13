/*
 * Decompiled with CFR 0.152.
 */
public class AVLTree {
    public int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return this.getHeight(node.left) - this.getHeight(node.right);
    }

    public int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(this.getHeight(node.left), this.getHeight(node.right));
    }

    public Node insert(Node node, int n) {
        if (node == null) {
            return new Node(n);
        }
        if (n < node.key) {
            node.left = this.insert(node.left, n);
        } else if (n > node.key) {
            node.right = this.insert(node.right, n);
        }
        int n2 = this.getBalanceFactor(node);
        if (n2 > 1) {
            if (this.getBalanceFactor(node.left) >= 0) {
                return this.rotateRight(node);
            }
            node.left = this.rotateLeft(node.left);
            return this.rotateRight(node);
        }
        if (n2 < -1) {
            if (this.getBalanceFactor(node.right) <= 0) {
                return this.rotateLeft(node);
            }
            node.right = this.rotateRight(node.right);
            return this.rotateLeft(node);
        }
        return node;
    }

    public Node rotateLeft(Node node) {
        Node node2 = node.right;
        node.right = node2.left;
        node2.left = node;
        return node2;
    }

    public Node rotateRight(Node node) {
        Node node2 = node.left;
        node.left = node2.right;
        node2.right = node;
        return node2;
    }

    public static void main(String[] stringArray) {
        AVLTree aVLTree = new AVLTree();
        Node node = null;
        node = aVLTree.insert(node, 10);
        node = aVLTree.insert(node, 20);
        node = aVLTree.insert(node, 30);
        node = aVLTree.insert(node, 40);
        node = aVLTree.insert(node, 50);
        node = aVLTree.insert(node, 25);
    }
}
