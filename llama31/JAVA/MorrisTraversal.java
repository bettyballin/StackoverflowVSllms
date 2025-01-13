import java.lang.String;
public class MorrisTraversal {
    public static void traverse(Node root) {
        Node current = root;
        while (current != null) {
            if (current.left == null) {
                System.out.print(current.value + " ");
                current = current.right;
            } else {
                Node predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                } else {
                    predecessor.right = null;
                    System.out.print(current.value + " ");
                    current = current.right;
                }
            }
        }
    }

    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

	public static void main(String[] args) {
	}
}