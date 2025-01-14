import java.lang.String;
public class BSPTreeDepthCalculator {
    public int getDepth(BSPTreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = getDepth(node.getLeftChild());
        int rightDepth = getDepth(node.getRightChild());
        return Math.max(leftDepth, rightDepth) + 1;
    }
    public static void main(String[] args) {
    }
}

class BSPTreeNode {
    private BSPTreeNode leftChild;
    private BSPTreeNode rightChild;

    public BSPTreeNode(BSPTreeNode leftChild, BSPTreeNode rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public BSPTreeNode getLeftChild() {
        return leftChild;
    }

    public BSPTreeNode getRightChild() {
        return rightChild;
    }
}