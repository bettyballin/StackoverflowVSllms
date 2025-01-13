import java.util.List;
import java.util.ArrayList;

public class StringDiff {
    public static List<int[]> diff(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= s2.length(); j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1] + 1, dp[i - 1][j] + 1), dp[i][j - 1] + 1);
                }
            }
        }
        List<int[]> diffs = new ArrayList<>();
        int i = s1.length(), j = s2.length();
        while (i > 0 || j > 0) {
            if (i > 0 && j > 0 && s1.charAt(i - 1) == s2.charAt(j - 1)) {
                i--;
                j--;
            } else if (j > 0 && (i == 0 || dp[i][j] == dp[i][j - 1] + 1)) {
                diffs.add(new int[] { i, j - 1 });
                j--;
            } else if (i > 0 && (j == 0 || dp[i][j] == dp[i - 1][j] + 1)) {
                diffs.add(new int[] { i - 1, j });
                i--;
            } else {
                diffs.add(new int[] { i - 1, j - 1 });
                i--;
                j--;
            }
        }
        return diffs;
    }

    public static void main(String[] args) {
        List<int[]> diffs = diff("abcd", "aacd");
        System.out.println(diffs); // [[2, 2]]
        diffs = diff("maniac", "brainiac");
        System.out.println(diffs); // [[0, 0], [1, 1], [2, 2], [3, 3]]
    }
}