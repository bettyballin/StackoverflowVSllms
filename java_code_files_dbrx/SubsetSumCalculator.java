public class SubsetSumCalculator {
    public static long subsetSum(int[] a, int N, int L, int V) {
        // dp[i][j] := num ways to select j elements from 1..i having sum < V
        long[][] dp = new long[N + 1][L + 1];

        dp[0][0] = 1; // there is one way (empty) with sum < V for first zero numbers.

        for (int i = 1; i <= N; ++i) {
            int currNum = a[i - 1]; // current number we are adding in the set
            dp[i][0] = 1L; // one way to construct sum < V from zero elements.
            for (int j = 1; j <= L && j <= i; ++j) { // all possible subset size up to i and no more than L
                dp[i][j] = dp[i - 1][j]; // if don't add ai, same number of ways as subset sum for fewer items.
                dp[i][j] += (currNum < V) ? dp[i - 1][j - 1] : 0; // if add ai and resultant is still less than V, add more possibilities.
            }
        }
        return dp[N][L]; // print last cell of table for total ways.
    }

    public static void main(String[] args) {
    }
}