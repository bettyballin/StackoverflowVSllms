import java.lang.String;

public class RedBlackTree_1_1 {
    private Node root;

    private static class Node {
        int key;
        Node left;
        Node right;
        boolean isRed;

        Node(int key) {
            this.key = key;
            this.left = null;
            this.right = null;
            this.isRed = true;
        }
    }

    public void insert(int key) {
        Node node = new Node(key);
        if (root == null) {
            root = node;
            root.isRed = false;
        } else {
            insertNode(root, node);
        }
    }

    private void insertNode(Node current, Node node) {
        if (node.key < current.key) {
            if (current.left == null) {
                current.left = node;
            } else {
                insertNode(current.left, node);
            }
        } else {
            if (current.right == null) {
                current.right = node;
            } else {
                insertNode(current.right, node);
            }
        }

        // Balance the tree
        if (isRed(current.left) && isRed(current.left.left)) {
            rotateRight(current);
        } else if (isRed(current.right) && isRed(current.right.right)) {
            rotateLeft(current);
        }
    }

    private boolean isRed(Node node) {
        return node != null && node.isRed;
    }

    private void rotateLeft(Node node) {
        Node right = node.right;
        node.right = right.left;
        right.left = node;
    }

    private void rotateRight(Node node) {
        Node left = node.left;
        node.left = left.right;
        left.right = node;
    }

    public static void main(String[] args) {
        RedBlackTree_1 tree = new RedBlackTree_1();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
    }
}