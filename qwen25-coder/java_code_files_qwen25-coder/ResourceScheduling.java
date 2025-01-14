import java.lang.String;
public class ResourceScheduling {
    public static int countPermutations(int[][] compatibilityMatrix, int length) {
        int n = compatibilityMatrix.length;
        // dp[i] will store the number of valid sequences ending with digit i of length j
        int[][] dp = new int[length + 1][n];

        // Base case: For sequences of length 1, each single-digit sequence is valid
        for (int i = 0; i < n; i++) {
            dp[1][i] = compatibilityMatrix[i][i] != 0 ? 1 : 0;
        }

        // Fill up the dp table
        for (int len = 2; len <= length; len++) {
            for (int j = 0; j < n; j++) {  // Ending digit is j
                for (int i = 0; i < n; i++) {  // Previous digit can be any valid i
                    if (compatibilityMatrix[i][j] == 1) {
                        dp[len][j] += dp[len - 1][i];
                    }
                }
            }
        }

        // Sum up all sequences of the required length
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += dp[length][i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] compatibilityMatrix = {
                {0, 0, 1, 1, 0},
                {0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0}
        };
        int length = 3;
        System.out.println("Number of valid sequences of length " + length + ": " + countPermutations(compatibilityMatrix, length));
    }
}