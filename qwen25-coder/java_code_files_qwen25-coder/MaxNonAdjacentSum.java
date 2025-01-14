import java.lang.String;
public class MaxNonAdjacentSum {
    public static int findMaxNonAdjacentSum(int[] A) {
        if (A == null || A.length == 0) return 0;
        
        int n = A.length;
        if (n == 1) return A[0];
        
        int[] dp = new int[n];
        dp[0] = A[0];
        dp[1] = Math.max(A[0], A[1]);
        
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1], A[i] + dp[i-2]);
        }
        
        return dp[n-1];
    }

    public static void main(String[] args) {
        int[] A = {1, 51, 3, 1, 100, 199, 3};
        System.out.println("Max Sum of Non-Adjacent Elements: " + findMaxNonAdjacentSum(A)); // Output should be 251
    }
}