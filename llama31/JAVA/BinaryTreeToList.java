import java.lang.String;
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

public class BinaryTreeToList {
    public static void flatten(Node root) {
        if (root == null) return;

        // Recursively flatten the left and right subtrees
        flatten(root.left);
        flatten(root.right);

        // If the left child is not null, reassign the right child of the left subtree
        // to the right child of the root, and then reassign the left child of the root
        // to null. This effectively "flattens" the left subtree into a linked list.
        if (root.left != null) {
            Node rightmost = root.left;
            while (rightmost.right != null) {
                rightmost = rightmost.right;
            }
            rightmost.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }

    public static void printList(Node root) {
        while (root != null) {
            System.out.print(root.value + " ");
            root = root.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        flatten(root);
        printList(root); // prints: 1 2 4 5 3
    }
}