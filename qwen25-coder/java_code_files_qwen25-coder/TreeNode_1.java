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

public class MorrisTraversal {

    public static void morrisInorder(TreeNode root) {
        TreeNode current = root;

        while (current != null) {
            if (current.left == null) {
                System.out.print(current.val + " ");
                current = current.right; // Move to the right subtree
            } else {
                // Find the inorder predecessor (rightmost of left subtree)
                TreeNode pre = current.left;
                while (pre.right != null && pre.right != current) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                    pre.right = current; // Make a temporary link to root
                    current = current.left; // Move to the left subtree
                } else {
                    // Revert the changes made to restore the original tree
                    // It has already been visited, so now we visit it
                    System.out.print(current.val + " ");
                    pre.right = null;
                    current = current.right; // Move to the right subtree
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        morrisInorder(root); // Output: 1 2 3 4 5
    }
}