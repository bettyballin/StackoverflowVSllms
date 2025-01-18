import java.lang.String;

public class TreeNode {
    int val;     // node value (0,1,2,3..)
    TreeNode left;    // Left child or null if none
    TreeNode right;   // Right child or null if none
    boolean originalState;  // True if current state equals to the initial tree
    boolean swapAttempted;  // To track whether this node has tried a swapping attempt after each recursive call.

    // Method to perform permutation without lists. Return true when no more permutations are possible, false otherwise.
    boolean permute(TreeNode current) {
        if (current == null || current.swapAttempted) return true; // No further swapping required if leaf node or already tried

        boolean leftSwapped = permute(current.left);   // Try permuting in the left subtree first
        boolean rightSwapped = leftSwapped ? permute(current.right) : false;  // If all permutations of left tried, try right. It is already exhausted as it follows DFS on return

        current.swapAttempted = true;   // Ensure node state persists till further recursive call for this same path

        if (leftSwapped && !rightSwapped) {  // If only left subtree swapped, also try swapping the right child in this pass
            boolean successfulSwap = swap(current.left, current);   // Swap current with its right node and update their original states accordingly.
            return !successfulSwap;  // If no further swap possible return true else false to continue processing for deeper nodes
        } else { // if swaps could be done in both subtrees or none, just try again with a fresh state next time this node gets considered
            current.swapAttempted = false;   // Reset swap attempt so that another pass of DFS is tried on this path.
            return true;  // It's not required to perform permutation here anymore
        }
    }

    boolean swap(TreeNode a, TreeNode b) {
        if (a == null || b == null) return false;

        // Swap values
        int tempVal = a.val;
        a.val = b.val;
        b.val = tempVal;

        // Swap left child
        TreeNode tempLeft = a.left;
        a.left = b.left;
        b.left = tempLeft;

        // Swap right child
        TreeNode tempRight = a.right;
        a.right = b.right;
        b.right = tempRight;

        // Swap the originalState
        boolean tempOriginalState = a.originalState;
        a.originalState = b.originalState;
        b.originalState = tempOriginalState;

        // Swap swapAttempted
        boolean tempSwapAttempted = a.swapAttempted;
        a.swapAttempted = b.swapAttempted;
        b.swapAttempted = tempSwapAttempted;

        return true;
    }

    public static void main(String[] args) {
        // Code to test the TreeNode class
    }
}