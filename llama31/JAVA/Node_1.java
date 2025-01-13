import java.lang.String;

public class Node_1 {
    int key;
    Node left;
    Node right;

    public Node(int key) {
        this.key = key;
        left = null;
        right = null;
    }
}

public class BST {
    Node root;

    public void insert(int key) {
        root = insertRecursive(root, new Node(key));
    }

    private Node insertRecursive(Node current, Node newNode) {
        if (current == null) {
            return newNode;
        } else if (newNode.key < current.key) {
            current.left = insertRecursive(current.left, newNode);
        } else {
            current.right = insertRecursive(current.right, newNode);
        }
        return current;
    }

    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(8);
        bst.insert(3);
        bst.insert(10);
        bst.insert(1);
        bst.insert(6);
        bst.insert(14);
        bst.insert(4);
        bst.insert(7);
        bst.insert(13);
    }
}