// Define the Node class
class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

// Define the MorrisTraversal class
class MorrisTraversal {
    public static void traverse(Node root) {
        while (root != null) {
            if (root.left == null) {
                System.out.print(root.data + " ");
                root = root.right;
            } else {
                Node current = root.left;
                while (current.right != null && current.right != root) {
                    current = current.right;
                }

                if (current.right == null) {
                    current.right = root;
                    root = root.left;
                } else {
                    current.right = null;
                    System.out.print(root.data + " ");
                    root = root.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        MorrisTraversal.traverse(root); // prints: 1 2 4 5 3
    }
}