import java.lang.String;
public class SubsetSumCount {
    public static int countSubsets(int[] nums, int L, int V) {
        int n = nums.length;
        // dp[i][j] will be the number of ways to get sum j with i elements
        int[][] dp = new int[L + 1][V];

        for (int i = 0; i <= L; i++) {
            dp[i][0] = 1; // One way to have a zero sum: take no elements
        }

        for (int num : nums) {
            for (int i = L; i >= 1; i--) { // Start from the end to reduce space complexity
                for (int j = V - 1; j >= num; j--) {
                    dp[i][j] += dp[i - 1][j - num];
                }
            }
        }

        int result = 0;
        for (int j = 0; j < V; j++) {
            result += dp[L][j];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] S = {1, 2, 3, 4};
        int L = 2;
        int V = 5;
        System.out.println("Number of valid subsets: " + countSubsets(S, L, V));
    }
}