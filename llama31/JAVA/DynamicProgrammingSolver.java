public class DynamicProgrammingSolver {
    public static void main(String[] args) {
        int N = 10; // define the size of the dp array
        int[][][] dp = new int[N][N][N];

        // initialize the dp array
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                for (int k = 0; k < N; ++k) {
                    // initialize dp[i][j][k] with some value
                    dp[i][j][k] = 0;
                }
            }
        }

        // the original code
        for (int i = 1; i < N; ++i) {
            for (int j = 1; j < N; ++j) {
                for (int k = 1; k < N; ++k) {
                    dp[i][j][k] = Math.max(dp[i-1][j][k], Math.max(dp[i][j-1][k], dp[i][j][k-1]));
                }
            }
        }
    }
}