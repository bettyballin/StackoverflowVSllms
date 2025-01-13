/*
 * Decompiled with CFR 0.152.
 */
public class LevenshteinDistance {
    public static int levenshteinDistance(String string, String string2) {
        int n;
        int[][] nArray = new int[string.length() + 1][string2.length() + 1];
        for (n = 0; n <= string.length(); ++n) {
            nArray[n][0] = n;
        }
        for (n = 0; n <= string2.length(); ++n) {
            nArray[0][n] = n;
        }
        for (n = 1; n <= string.length(); ++n) {
            for (int i = 1; i <= string2.length(); ++i) {
                int n2 = string.charAt(n - 1) == string2.charAt(i - 1) ? 0 : 1;
                nArray[n][i] = Math.min(Math.min(nArray[n - 1][i] + 1, nArray[n][i - 1] + 1), nArray[n - 1][i - 1] + n2);
            }
        }
        return nArray[string.length()][string2.length()];
    }

    public static void main(String[] stringArray) {
        String string = "New York";
        String string2 = "NewYork";
        System.out.println(LevenshteinDistance.levenshteinDistance(string, string2));
    }
}
