import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

class TreeNode {
    int val;
    List<TreeNode> neighbors;

    TreeNode(int x) {
        val = x;
        neighbors = new ArrayList<TreeNode>();
    }
}

public class MinVertexCoverTree {

    // Returns an array where the first element is the size of the vertex cover if we include this node
    // and the second element is the size of the vertex cover if we do not include this node.
    private int[] findMinVC(TreeNode root, Map<TreeNode, int[]> memo) {
        if (root == null) return new int[]{0, 0};

        if (memo.containsKey(root)) return memo.get(root);

        int includeThis = 1;
        int excludeThis = 0;

        for (TreeNode neighbor : root.neighbors) {
            int[] res = findMinVC(neighbor, memo);
            // If we include this node we can choose either to include or exclude its children
            includeThis += Math.min(res[0], res[1]);
            // If we do not include this node we must include all of its children to cover the edges
            excludeThis += res[0];
        }

        memo.put(root, new int[]{includeThis, excludeThis});
        return memo.get(root);
    }

    public int minVertexCover(TreeNode root) {
        Map<TreeNode, int[]> memo = new HashMap<TreeNode, int[]>();
        int[] result = findMinVC(root, memo);
        // The answer will be the minimum of including or excluding the root
        return Math.min(result[0], result[1]);
    }

    public static void main(String[] args) {
    }
}