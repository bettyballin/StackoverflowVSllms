import java.lang.String;

public class StringConcatenator_1_1 {
    public static String concat(String s1, String s2) {
        if (s1 == null) return s2;
        if (s2 == null) return s1;

        int[] lps = computeLPS(s2);
        int i = s1.length() - 1;
        int j = 0;
        while (i >= 0 && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i--;
                j++;
            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                break;
            }
        }

        StringBuilder sb = new StringBuilder(s1);
        if (j == 0) {
            sb.append(s2);
        } else {
            sb.append(s2.substring(j));
        }
        return sb.toString();
    }

    private static int[] computeLPS(String s) {
        int[] lps = new int[s.length()];
        int j = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = lps[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            lps[i] = j;
        }
        return lps;
    }

    public static void main(String[] args) {
        System.out.println(concat("abc", "def")); // Test the concat method
    }
}