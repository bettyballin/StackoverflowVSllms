import java.lang.String;
import java.lang.Integer;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        // If the node is a leaf node, return depth as 1
        if (root.left == null && root.right == null) {
            return 1;
        }
        
        int leftDepth = Integer.MAX_VALUE;
        int rightDepth = Integer.MAX_VALUE;
        
        if (root.left != null) {
            leftDepth = minDepth(root.left);
        }
        
        if (root.right != null) {
            rightDepth = minDepth(root.right);
        }
        
        return Math.min(leftDepth, rightDepth) + 1;
    }

	public static void main(String[] args) {
	}
}