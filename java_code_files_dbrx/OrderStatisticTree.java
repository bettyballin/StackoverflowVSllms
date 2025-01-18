import java.util.Random;

public class OrderStatisticTree<T extends Comparable<T>> {
    private Node root;
    Random random = new Random();

    public class Node {
        T data;
        int size; // Number of nodes in this node's subtree
        Node left, right;

        Node(T data) {
            this.data = data;
            this.size = 1;
            left = null;
            right = null;
        }
    }

    OrderStatisticTree()  {
        root = null;
    }

    private int getSize(Node x){
        if (x == null ) return  0;
        else return x.size;
    }

    public T insert(T elem) {    // Add new element to the tree
        root = siftUp(root, elem, random.nextInt());
        return elem;
    }

    private Node siftUp(Node h, T elem, int idx){
        if (h == null ) return new Node(elem);// Inserting in an empty tree
        int leftSize = getSize(h.left ); // Check current subtree size
        if (idx < leftSize) {
            h.left = siftUp(h.left, elem, idx);
        } else if (idx == leftSize + 1) {
            Node newNode = new Node(elem);
            newNode.size += getSize(h.right);// size of the right subtree
            h.size++;
            return split(newNode, elem , h.right);
        } else {
            h.right = siftUp(h.right, elem, idx - (leftSize +1));
            h.size += 1; // Update size of current node as well since an element is inserted in this subtree
        }
        return h;
    }

    private Node join(Node x, T elem, Node y){
        if (x == null) return new Node(elem);// We were inserting into empty tree. Nothing to join with root
        else {
            int leftSize  = getSize(x.left ); // Compute the size of node x subtree and decide where to go from here
            if (random.nextInt() < leftSize ) {
                x.right = join(x.right, elem, y);
                update_size(x);
                return x;
            } else {
                Node newNode = new Node(elem);
                newNode.left = join(x, elem, y); // Insert as root and connect left subtree here
                update_size(newNode);
                return newNode;
            }
        }
    }

    private Node split(Node h, T k1, Node y){
        // This function works as complementary with join to maintain our size invariant. More details in CLR and book referenced above.
        // For now, throw an exception to make code compilable
        throw new UnsupportedOperationException("split method is not implemented");
    }

    private void update_size(Node x){
        x.size = 1 + getSize(x.left) + getSize(x.right);
    }

    // Other operations such as remove(int idx, ElementType elem), find_by_order(), etc., will be defined here.

} // end of class definition