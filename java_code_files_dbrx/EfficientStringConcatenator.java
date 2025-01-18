public class EfficientStringConcatenator {
    public static String efficientConcat(String s1, String s2) {
        if (s1 == null || s2 == null)
            return null;

        int n = s2.length();

        /* Precompute prefix table from end to beginning */
        int[] prefix_table = new int[n + 1];

        for (int i = 0, j = n - 1; i < n && j >= 0;) {
            if (s1.charAt(i) == s2.charAt(j)) { // Match
                i++;
                j--;
                prefix_table[n - j] = i;
                continue;
            } else if (prefix_table[n - j] != 0) {
                i = prefix_table[n - j];
            } else {
                i = 0;
                j--;
            }
        }

        /* Find the longest overlapping part */
        int overlapLen = prefix_table[n];

        /* Construct final concatenated result */
        if (overlapLen > 0)
            s2 = s2.substring(overlapLen);
        return new StringBuilder().append(s1).append(s2).toString();
    }

    public static void main(String[] args) {
    }
}