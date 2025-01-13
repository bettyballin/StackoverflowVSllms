import java.lang.String;

// Define the Node class
class Node {
    Node left;
    Node right;
}

public class BinaryTreeHeightCalculator {
    public int getHeight(Node node) {
        if (node == null) {
            return -1;
        } else {
            return 1 + Math.max(getHeight(node.left), getHeight(node.right));
        }
    }

    public static void main(String[] args) {
        // Create an instance of BinaryTreeHeightCalculator to use the getHeight method
        BinaryTreeHeightCalculator calculator = new BinaryTreeHeightCalculator();
        
        // Create a binary tree for testing
        Node root = new Node();
        root.left = new Node();
        root.right = new Node();
        root.left.left = new Node();
        
        // Calculate the height of the binary tree
        int height = calculator.getHeight(root);
        
        // Print the result
        System.out.println("Height of the binary tree: " + height);
    }
}