import java.lang.String;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class TreeShapeChecker {

    public boolean areShapesEqual(TreeNode t1, TreeNode t2) {
        // If both nodes are null, then the shapes match up to this point
        if (t1 == null && t2 == null) {
            return true;
        }

        // If one of them is not null, but the other is, the shapes don't match
        if (t1 == null || t2 == null) {
            return false;
        }

        // Both nodes are non-null, so continue checking their children
        return areShapesEqual(t1.left, t2.left) && areShapesEqual(t1.right, t2.right);
    }

	public static void main(String[] args) {
	}
}