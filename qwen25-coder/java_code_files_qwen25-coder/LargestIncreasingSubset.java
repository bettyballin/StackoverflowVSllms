import java.util.ArrayList;
import java.util.List;

public class LargestIncreasingSubset {
    public static List<Integer> findLargestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();

        int n = nums.length;
        int[] dp = new int[n];
        int[] prevIndex = new int[n];
        int maxIndex = 0;

        // Initialize
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            prevIndex[i] = -1;
        }

        // Compute the LIS values and keep track of previous indices
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prevIndex[i] = j;
                }
            }
            // Update maxIndex if needed
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }

        // Reconstruct the sequence
        List<Integer> result = new ArrayList<>();
        for (; maxIndex >= 0; maxIndex = prevIndex[maxIndex]) {
            result.add(0, nums[maxIndex]);
            if (prevIndex[maxIndex] == -1) break;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] A = {50, 1, 4, 9, 2, 18, 6, 3, 7, 10};
        List<Integer> result = findLargestIncreasingSubsequence(A);
        System.out.println("Largest Increasing Non-Contiguous Subset: " + result);
    }
}