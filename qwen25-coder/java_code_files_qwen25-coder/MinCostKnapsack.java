import java.lang.String;
import java.lang.Integer;
public class MinCostKnapsack {
    public static int minCost(int[] values, int[] costs, int minValue) {
        int n = values.length;
        // Initialize the DP array with a large number
        int[] dp = new int[minValue + 1];
        for (int i = 1; i <= minValue; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        // Fill the dp array
        for (int i = 0; i < n; i++) {
            for (int j = minValue; j >= values[i]; j--) {
                if (dp[j - values[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - values[i]] + costs[i]);
                }
            }
        }

        return dp[minValue];
    }

    public static void main(String[] args) {
        int[] values = {20, 7, 1};
        int[] costs = {11, 5, 2};
        int minValue = 30;

        int result = minCost(values, costs, minValue);
        if (result != Integer.MAX_VALUE) {
            System.out.println("Minimum cost to achieve at least value " + minValue + " is: " + result);
        } else {
            System.out.println("It's not possible to achieve the minimum value with the given items.");
        }
    }
}