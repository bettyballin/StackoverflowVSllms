import java.lang.String;
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x) { val = x; }
}

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;} //1st rule: both nodes are null
             else if (p == null || q==null){//2nd rule : either one of tree have a null node while the other one  has value.
           return false; }
        else{   return ( p.val == q.val && isSameTree(p.left,q.left)&&isSameTree(p.right,q.right));}// 3rd rule : check if both nodes are same and also their children should be same using recursion here.
    }

	public static void main(String[] args) {
	}
}