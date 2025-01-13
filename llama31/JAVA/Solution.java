import java.lang.String;
import java.lang.Integer;
class Node {
    int val;
    Node left;
    Node right;
    Node(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

public class Solution {
    public int shortestPath(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int left = root.left != null ? shortestPath(root.left) : Integer.MAX_VALUE;
        int right = root.right != null ? shortestPath(root.right) : Integer.MAX_VALUE;
        return 1 + Math.min(left, right);
    }

	public static void main(String[] args) {
	}
}