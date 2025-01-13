/*
 * Decompiled with CFR 0.152.
 */
class BalancedBST {
    Node root;

    BalancedBST() {
    }

    public void insert(int n, int n2) {
        this.root = this.insert(this.root, n, n2);
    }

    public void delete(int n) {
        this.root = this.delete(this.root, n);
    }

    public int getIndex(int n) {
        return this.getIndex(this.root, n);
    }

    private Node insert(Node node, int n, int n2) {
        if (node == null) {
            return new Node(n, n2);
        }
        if (n < node.value) {
            node.left = this.insert(node.left, n, n2);
        } else if (n > node.value) {
            node.right = this.insert(node.right, n, n2);
        }
        return node;
    }

    private Node delete(Node node, int n) {
        if (node == null) {
            return null;
        }
        if (n < node.value) {
            node.left = this.delete(node.left, n);
        } else if (n > node.value) {
            node.right = this.delete(node.right, n);
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            Node node2 = node.right;
            while (node2.left != null) {
                node2 = node2.left;
            }
            node.value = node2.value;
            node.right = this.delete(node.right, node2.value);
        }
        return node;
    }

    private int getIndex(Node node, int n) {
        if (node == null) {
            return -1;
        }
        if (n < node.value) {
            return this.getIndex(node.left, n);
        }
        if (n > node.value) {
            return this.getIndex(node.right, n);
        }
        return node.index;
    }

    public int getValue(int n) {
        return this.getValue(this.root, n);
    }

    private int getValue(Node node, int n) {
        if (node == null) {
            return -1;
        }
        if (node.index == n) {
            return node.value;
        }
        int n2 = this.getValue(node.left, n);
        if (n2 != -1) {
            return n2;
        }
        return this.getValue(node.right, n);
    }
}
