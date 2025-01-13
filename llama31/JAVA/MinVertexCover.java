import java.lang.String;
import java.util.Arrays; // added import statement for Arrays class

public class MinVertexCover {
    private int[] dp; // dp[i] stores the minimum vertex cover for subtree rooted at i
    private int[][] neighbours; // neighbours[i] stores the neighbours of node i

    public MinVertexCover(int[][] neighbours) {
        this.neighbours = neighbours;
        dp = new int[neighbours.length];
        Arrays.fill(dp, -1); // initialize dp array with -1
    }

    public int getMinVertexCover(int node) {
        if (dp[node] != -1) return dp[node]; // return cached result if available

        int minCover = 0;

        // Base case: leaf node
        if (neighbours[node].length == 0) {
            dp[node] = 0;
            return 0;
        }

        // Recursive case: compute minimum vertex cover for each child subtree
        for (int child : neighbours[node]) {
            minCover += getMinVertexCover(child);
        }

        // Consider two cases: include current node in vertex cover or not
        int includeNode = 1 + minCover; // include current node in vertex cover
        int excludeNode = minCover; // exclude current node from vertex cover

        // Choose the minimum of the two cases
        dp[node] = Math.min(includeNode, excludeNode);
        return dp[node];
    }

	public static void main(String[] args) {
		int[][] neighbours = {{1, 2}, {3}, {3}, {}};
		MinVertexCover mvc = new MinVertexCover(neighbours);
		System.out.println("Minimum Vertex Cover: " + mvc.getMinVertexCover(0));
	}
}