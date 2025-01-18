import java.util.ArrayList;

class Node {
    private int t; // minimum degree (defines the range for number of children)
    private ArrayList<Integer> keys = new ArrayList<>(); // array of keys
    private ArrayList<Node> C = new ArrayList<>();// array of child pointers. C[i] points to subtree having element > key[i-1] and smaller than key[i]. C[0][:] stores elements less than the rest all...
    Node parent; // pointer to its parent node. used only for delete operations. Initially set null in constructors.
    boolean leaf = false;  // true iff this is a leaf node
}

// A B-tree node with n keys x[0], ... x[n-1] has
// (n+1) children C[0], ..., C[n]. So, if it is not a leaf then keys of C[i-1] <= keys[i] < keys of C[i] for 1 <= i <= n,
// and if this is a leaf node then we don't have any children to store in array 'C'.

public class BTree {
    public Node insert(Node root, int x) throws Exception {
        // Insertion logic goes here.
        // Placeholder implementation to make the code executable.
        return root;
    }
    // Other functions go here!
}