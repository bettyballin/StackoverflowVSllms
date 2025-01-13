import java.lang.String;
public class Main_639 {
    public static void main(String[] args) {
        int[][] compatibilityMatrix = {
            {0, 0, 1, 1, 0},
            {0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0},
            {0, 1, 0, 0, 0}
        };
        int length = 3;
        long[][] dp = new long[length + 1][compatibilityMatrix.length];
        
        // Initialize base case
        for (int i = 0; i < compatibilityMatrix.length; i++) {
            dp[1][i] = 1;
        }
        
        // Fill up the table
        for (int i = 2; i <= length; i++) {
            for (int j = 0; j < compatibilityMatrix.length; j++) {
                for (int k = 0; k < compatibilityMatrix.length; k++) {
                    if (compatibilityMatrix[k][j] == 1) {
                        dp[i][j] += dp[i - 1][k];
                    }
                }
            }
        }
        
        // Calculate the total number of valid strings
        long total = 0;
        for (int i = 0; i < compatibilityMatrix.length; i++) {
            total += dp[length][i];
        }
        
        System.out.println("Total number of valid strings: " + total);
    }
}