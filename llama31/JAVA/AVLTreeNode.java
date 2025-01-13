import java.lang.String;

public class AVLTreeNode {
    int value;
    AVLTreeNode left;
    AVLTreeNode right;
    int balanceFactor;

    public AVLTreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.balanceFactor = 0;
    }
}

public class AVLTree {
    AVLTreeNode root;

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private AVLTreeNode insertRecursive(AVLTreeNode node, int value) {
        if (node == null) {
            return new AVLTreeNode(value);
        }

        if (value < node.value) {
            node.left = insertRecursive(node.left, value);
        } else if (value > node.value) {
            node.right = insertRecursive(node.right, value);
        }

        // Update balance factor
        node.balanceFactor = getBalanceFactor(node);

        // Balance the tree
        if (node.balanceFactor > 1) {
            // Left-Left Case
            if (node.left.balanceFactor > 0) {
                node = rotateRight(node);
            } else {
                // Left-Right Case
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            }
        } else if (node.balanceFactor < -1) {
            // Right-Right Case
            if (node.right.balanceFactor < 0) {
                node = rotateLeft(node);
            } else {
                // Right-Left Case
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
        }

        return node;
    }

    private AVLTreeNode rotateLeft(AVLTreeNode node) {
        AVLTreeNode temp = node.right;
        node.right = temp.left;
        temp.left = node;
        return temp;
    }

    private AVLTreeNode rotateRight(AVLTreeNode node) {
        AVLTreeNode temp = node.left;
        node.left = temp.right;
        temp.right = node;
        return temp;
    }

    private int getBalanceFactor(AVLTreeNode node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    private int getHeight(AVLTreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);
    }
}