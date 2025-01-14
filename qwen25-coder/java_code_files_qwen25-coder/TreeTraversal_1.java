import java.lang.String;
import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversal_1 {
    void iterativeBFS(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.value + " ");

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeTraversal_1 tree = new TreeTraversal_1();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Iterative BFS:");
        tree.iterativeBFS(root);  // Output: 1 2 3 4 5
    }
}

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode(int value) {
        this.value = value;
    }
}