import java.lang.String;
import java.util.Stack;

class TreeNode {
    String val;
    TreeNode left;
    TreeNode right;

    TreeNode(String val) {
        this.val = val;
    }
}

public class PostfixToExpressionTree {
    private static boolean isOperator(String c) {
        return "+-*/^".indexOf(c) != -1;
    }

    public static TreeNode buildExpressionTree(String postfix) {
        Stack<TreeNode> stack = new Stack<>();

        for (String token : postfix.split(" ")) {
            if (isOperator(token)) {
                TreeNode right = stack.pop();
                TreeNode left = stack.pop();

                TreeNode node = new TreeNode(token);
                node.left = left;
                node.right = right;

                stack.push(node);
            } else {
                stack.push(new TreeNode(token));
            }
        }

        return stack.pop();
    }

    // Helper method to print the tree
    public static void printInOrder(TreeNode root) {
        if (root == null) return;

        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        String postfix = "A 2 ^ 2 A * B * - B 2 ^ + A B - /";
        TreeNode root = buildExpressionTree(postfix);

        // Output the tree in in-order traversal
        printInOrder(root);
    }
}