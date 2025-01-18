public class RedBlackTree {
    private Node root;
    // Other implementations like Insert, Search, etc.

    void insert(int data){
        // Insertion Logic here
    }

    // Other methods
}

class Node {
    public int data;          // The value stored in this node
    public boolean color;     // True -> RED, False -> BLACK.
    public Node leftChild;    // Reference to the Left Child of this node
    public Node rightChild;   // Reference to the Right Child of this node
}