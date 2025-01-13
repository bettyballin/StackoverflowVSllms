// Define the Node class
class Node {
    Node left;
    Node right;
}

public class AVLTreeUtils {
    // Define the getHeight method
    public int getHeight(Node node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + Math.max(getHeight(node.left), getHeight(node.right));
        }
    }

    public int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        } else {
            return getHeight(node.left) - getHeight(node.right);
        }
    }

    public static void main(String[] args) {
        // Create an instance of AVLTreeUtils to access non-static methods
        AVLTreeUtils utils = new AVLTreeUtils();
        Node root = new Node();
        // Set up the tree structure to test the getBalanceFactor method
        root.left = new Node();
        System.out.println(utils.getBalanceFactor(root));
    }
}