import java.lang.String;

// Define the Node class
class Node {
    int key;
    Node left;
    Node right;

    public Node(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }
}

public class AVLTree {
    // Method to get the balance factor of a node
    public int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    // Method to get the height of a node
    public int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    public Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        } else if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        }

        int balanceFactor = getBalanceFactor(node);
        if (balanceFactor > 1) {
            if (getBalanceFactor(node.left) >= 0) {
                // Left-left case
                return rotateRight(node);
            } else {
                // Left-right case
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            }
        } else if (balanceFactor < -1) {
            if (getBalanceFactor(node.right) <= 0) {
                // Right-right case
                return rotateLeft(node);
            } else {
                // Right-left case
                node.right = rotateRight(node.right);
                return rotateLeft(node);
            }
        }

        return node;
    }

    public Node rotateLeft(Node node) {
        Node temp = node.right;
        node.right = temp.left;
        temp.left = node;
        return temp;
    }

    public Node rotateRight(Node node) {
        Node temp = node.left;
        node.left = temp.right;
        temp.right = node;
        return temp;
    }

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        Node root = null;
        root = avlTree.insert(root, 10);
        root = avlTree.insert(root, 20);
        root = avlTree.insert(root, 30);
        root = avlTree.insert(root, 40);
        root = avlTree.insert(root, 50);
        root = avlTree.insert(root, 25);
    }
}