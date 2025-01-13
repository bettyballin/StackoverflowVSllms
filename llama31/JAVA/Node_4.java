import java.lang.String;

public class Node_4_4 {
    private final int key;
    private final Node_4 left;  // Changed Node to Node_4
    private final Node_4 right;  // Changed Node to Node_4

    public Node_4(int key, Node_4 left, Node_4 right) {  // Changed Node to Node_4
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public Node_4 insert(int newKey) {
        // Create a new node with the updated key and recursively updated children
        if (newKey < this.key) {
            return new Node_4(key, left.insert(newKey), right);  // Changed Node to Node_4
        } else {
            return new Node_4(key, left, right.insert(newKey));  // Changed Node to Node_4
        }
    }

    public Node_4 delete(int key) {
        // Create a new node with the updated key and recursively updated children
        if (key < this.key) {
            return new Node_4(key, left.delete(key), right);  // Changed Node to Node_4
        } else if (key > this.key) {
            return new Node_4(key, left, right.delete(key));  // Changed Node to Node_4
        } else {
            // Node to be deleted has no children
            return null;
        }
    }

    public Node_4 query(int key) {
        // Recursively search for the key in the node and its children
        if (key == this.key) return this;
        if (key < this.key) return left.query(key);
        return right.query(key);
    }

    public static void main(String[] args) {
        // Create a binary search tree
        Node_4 root = new Node_4(5, null, null);
        root = root.insert(3);
        root = root.insert(7);
        root = root.insert(2);
        root = root.insert(4);
        root = root.insert(6);
        root = root.insert(8);

        // Query the tree
        Node_4 result = root.query(4);
        if (result != null) {
            System.out.println("Key found: " + result.key);
        } else {
            System.out.println("Key not found");
        }

        // Delete a key from the tree
        root = root.delete(4);

        // Query the tree again
        result = root.query(4);
        if (result != null) {
            System.out.println("Key found: " + result.key);
        } else {
            System.out.println("Key not found");
        }
    }
}