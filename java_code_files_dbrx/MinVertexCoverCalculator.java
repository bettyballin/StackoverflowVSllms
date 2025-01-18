import java.lang.String;
import java.util.Objects;

public class MinVertexCoverCalculator {
    public int findMinVertexCover(TreeNode root) {
        // Base case 1 - if node is null, return 0
        if (root == null) return 0;

        // Color root black and children white initially.
        root.color = "black";
        int blackNodes = 1;
        int whiteNodes = findMinVertexCover(root.left);
        if (!Objects.equals(root.color, "black")) {
            blackNodes++;
            // If the parent node is white, all its children are also in vertex cover (colored white).
            root.colorChildWhite();
            // This is not required for minVC but updated for further operations on tree/nodes, if needed.
        }

        return Math.min(whiteNodes + blackNodes - 1, findMinVertexCover(root.right) + blackNodes);
    }

    public static void main(String[] args) {
        // You can add test code here if needed
    }
}

class TreeNode {
    String color;
    TreeNode left;
    TreeNode right;

    public void colorChildWhite() {
        if (left != null) left.color = "white";
        if (right != null) right.color = "white";
    }
}