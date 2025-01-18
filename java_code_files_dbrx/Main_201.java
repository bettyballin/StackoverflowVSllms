public class Main {

    static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void permute(Node node) {
        if (node == null)
            return;
        // Swap left and right
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
        // Continue DFS traversal
        permute(node.left);
        permute(node.right);
    }

    public static void main(String[] args) {
        // Build a sample binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        // This will trigger the Depth-First Search traversal and swapping logic described.
        permute(root);
    }
}