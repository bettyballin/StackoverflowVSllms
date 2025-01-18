import java.lang.String;
import java.lang.Integer;
public class TreeNode_2 {
    class TreeNode {
        int val;
        TreeNode left, right;
    }
    
    private static class Pair {
        Integer minPathLength = null;
        boolean isLeaf = false;
    }
    
    public int shortestPath(TreeNode node) {
        return helper(node).minPathLength.intValue();
    }
    
    private Pair helper(TreeNode node) {
        if (node == null) {
            Pair resPair = new Pair();
            resPair.isLeaf = true;
            resPair.minPathLength = 0;
            return resPair;
        }
    
        // recursive calls
        Pair leftRes = helper(node.left);
        Pair rightRes = helper(node.right);
    
        Pair pairResult = new Pair();
    
        if (leftRes.isLeaf || rightRes.isLeaf) {  // found leaf or leaves in one of the child node's subtree
            int length = leftRes.minPathLength != null ? leftRes.minPathLength + 1 : Integer.MAX_VALUE;
            if (rightRes.minPathLength != null && rightRes.isLeaf) { // a leaf found in right sub tree also, find min path from both sides
                length = Math.min(length, rightRes.minPathLength.intValue());
            }
    
            pairResult.minPathLength = length;
        } else if (leftRes.minPathLength != null && rightRes.minPathLength != null) {  // both not leaf nodes, have found min path from both sides
            int curMinimum = Math.min(leftRes.minPathLength.intValue(), rightRes.minPathLength.intValue());
            pairResult.minPathLength = curMinimum + 1;
        }
        // at least one of the current node child node is a leaf node or has found min path to leaf from its sub tree
        return pairResult;
    }
    	public static void main(String[] args) {
    	}
}