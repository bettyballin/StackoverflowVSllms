import java.lang.String;
public class RedBlackTree {
    private Node root;

    private static class Node {
        double key;
        Node left, right, parent;
        boolean isRed;

        Node(double key) {
            this.key = key;
            isRed = true; // new nodes are always red
        }
    }

    public void insert(double key) {
        Node newNode = new Node(key);
        if (root == null) {
            root = newNode;
        } else {
            insertNode(root, newNode);
        }
    }

    private void insertNode(Node current, Node newNode) {
        if (newNode.key < current.key) {
            if (current.left == null) {
                current.left = newNode;
                newNode.parent = current;
            } else {
                insertNode(current.left, newNode);
            }
        } else {
            if (current.right == null) {
                current.right = newNode;
                newNode.parent = current;
            } else {
                insertNode(current.right, newNode);
            }
        }

        // balance the tree
        balanceTree(newNode);
    }

    private void balanceTree(Node node) {
        // implement Red-Black Tree balancing logic here
    }

	public static void main(String[] args) {
	}
}