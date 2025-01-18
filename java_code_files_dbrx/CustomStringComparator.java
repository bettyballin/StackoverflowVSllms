import java.lang.String;
import java.lang.Integer;
import java.util.Comparator;

public class CustomStringComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        // Get positions where the two strings start to differ and end to stop differing (including trailing characters).
        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) != s2.charAt(j)) break;
            i++; j++;
        }
        int s1End = s1.length(), s2End = s2.length();
        while (s1End > i && s2End > j) {
            if(s1.charAt(--s1End) != s2.charAt(--s2End)) break;
        }

        // Check the middle section for integers by trying to parse them as such and comparing.
        try {
            int numS1 = Integer.parseInt(s1.substring(i, ++s1End));
            int numS2 = Integer.parseInt(s2.substring(j, ++s2End));
            return Integer.compare(numS1, numS2);
        } catch (NumberFormatException ignored) { }

        // Fall back to normal string comparison if the middle section doesn't contain integers.
        return s1.compareTo(s2);
    }

	public static void main(String[] args) {
	}
}