import java.lang.String;
public class FibonacciHeap {
    // Node class representing a node in the heap
    private static class Node {
        int key;
        Node parent;
        Node child;
        Node left;
        Node right;
        int degree;
        boolean marked;

        public Node(int key) {
            this.key = key;
            this.parent = null;
            this.child = null;
            this.left = null;
            this.right = null;
            this.degree = 0;
            this.marked = false;
        }
    }

    // Root node of the heap
    private Node root;

    // Minimum node of the heap
    private Node minNode;

    // Number of nodes in the heap
    private int size;

    public FibonacciHeap() {
        this.root = null;
        this.minNode = null;
        this.size = 0;
    }

    // Insert a new node into the heap
    public void insert(int key) {
        Node node = new Node(key);
        if (root == null) {
            root = node;
            minNode = node;
        } else {
            // Add the new node to the circular doubly-linked list
            node.left = root.left;
            node.right = root;
            root.left.right = node;
            root.left = node;

            // Update the minimum node if necessary
            if (node.key < minNode.key) {
                minNode = node;
            }
        }
        size++;
    }

    // Extract the minimum node from the heap
    public int extractMin() {
        if (minNode == null) {
            throw new RuntimeException("Heap is empty");
        }

        int minKey = minNode.key;

        // Remove the minimum node from the heap
        if (minNode.child != null) {
            // Update the child nodes
            Node child = minNode.child;
            while (child != null) {
                Node nextChild = child.right;
                child.parent = null;
                child.left = root.left;
                child.right = root;
                root.left.right = child;
                root.left = child;
                child = nextChild;
            }
        }

        // Remove the minimum node from the circular doubly-linked list
        minNode.left.right = minNode.right;
        minNode.right.left = minNode.left;

        // Update the minimum node
        if (minNode == root) {
            root = minNode.right;
        }
        minNode = null;

        // Consolidate trees
        consolidate();

        size--;
        return minKey;
    }

    // Consolidate trees in the heap
    private void consolidate() {
        int maxDegree = (int) Math.floor(Math.log(size) / Math.log(2)) + 2;
        Node[] degrees = new Node[maxDegree];

        Node node = root;
        while (node != null) {
            Node nextNode = node.right;
            int degree = node.degree;
            while (degrees[degree] != null) {
                Node otherNode = degrees[degree];
                if (node.key > otherNode.key) {
                    // Swap nodes
                    Node temp = node;
                    node = otherNode;
                    otherNode = temp;
                }

                // Remove the other node from the circular doubly-linked list
                otherNode.left.right = otherNode.right;
                otherNode.right.left = otherNode.left;

                // Make the other node a child of the current node
                otherNode.parent = node;
                otherNode.right = otherNode;
                otherNode.left = otherNode;
                if (node.child == null) {
                    node.child = otherNode;
                } else {
                    // Add the other node to the circular doubly-linked list of child nodes
                    otherNode.left = node.child.left;
                    otherNode.right = node.child;
                    node.child.left.right = otherNode;
                    node.child.left = otherNode;
                }

                // Update the degree of the current node
                node.degree++;

                // Update the minimum node if necessary
                if (node.key < minNode.key) {
                    minNode = node;
                }

                degrees[degree] = null;
                degree++;
            }
            degrees[degree] = node;
            node = nextNode;
        }

        // Update the minimum node
        minNode = null;
        for (Node n : degrees) {
            if (n != null && (minNode == null || n.key < minNode.key)) {
                minNode = n;
            }
        }
    }

	public static void main(String[] args) {
	}
}