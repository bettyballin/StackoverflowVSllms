import java.util.LinkedList;
import java.util.Queue;

// Define the Node class
class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTreeTraversal {
    // Iterative Traversal using a Queue
    public void iterativeTraversal(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.value + " ");

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }

    // Recursive Traversal
    public void recursiveTraversal(Node node) {
        if (node == null) return;

        System.out.print(node.value + " ");
        recursiveTraversal(node.left);
        recursiveTraversal(node.right);
    }

    public static void main(String[] args) {
        BinaryTreeTraversal traversal = new BinaryTreeTraversal();

        // Create a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Iterative Traversal:");
        traversal.iterativeTraversal(root);
        System.out.println("\nRecursive Traversal:");
        traversal.recursiveTraversal(root);
    }
}