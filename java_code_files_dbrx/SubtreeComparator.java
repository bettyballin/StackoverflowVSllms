import java.lang.String;

public class SubtreeComparator {

    public boolean checkSubtree(Node current, Node target) {
        // compare nodes if equal go for checking subtrees recursively else return false
        if (nodesEqual(current, target)) {
            boolean leftCheck = true;
            boolean rightCheck = true;
            // check left and right trees recursively or use other efficient method
            if (null != current.getLeft() && null != target.getLeft()) {
                leftCheck = checkSubtree(current.getLeft(), target.getLeft());
            } else {
                leftCheck = (null == current.getLeft() && null == target.getLeft()); // check both are end nodes
            }

            if (null != current.getRight() && null != target.getRight()) {
                rightCheck = checkSubtree(current.getRight(), target.getRight());
            } else {
                rightCheck = (null == current.getRight() && null == target.getRight()); // check both are end nodes
            }
            return leftCheck && rightCheck;
        }
        return false;
    }

    private boolean nodesEqual(Node n1, Node n2) {
        // Implement the logic for comparing two nodes
        // This is a placeholder; actual implementation may vary
        return n1.equals(n2);
    }

    public static void main(String[] args) {
        // You can add test code here if needed
    }
}

class Node {
    private Node left;
    private Node right;
    private Object value;

    public Node(Object value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    // Override equals method if needed for nodesEqual comparison
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Node)) return false;
        Node other = (Node) obj;
        return (this.value == null ? other.value == null : this.value.equals(other.value));
    }
}