import java.lang.String;

public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
}

public class TreeTraversal {
    public static void traverse(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value);
        traverse(node.left);
        traverse(node.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        traverse(root);
    }
}