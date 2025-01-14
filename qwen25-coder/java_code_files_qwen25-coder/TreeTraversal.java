import java.lang.String;
import java.util.Stack;

class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int item) {
        value = item;
        left = right = null;
    }
}

public class TreeTraversal {
    void iterativeDFS(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.value + " ");

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public static void main(String[] args) {
        TreeTraversal tree = new TreeTraversal();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Iterative DFS:");
        tree.iterativeDFS(root);  // Output: 1 2 4 5 3
    }
}