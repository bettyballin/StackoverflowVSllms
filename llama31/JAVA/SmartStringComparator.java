import java.lang.String;
import java.lang.Integer;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SmartStringComparator implements Comparator<String> {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");

    @Override
    public int compare(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        // Find the common prefix
        int prefixLen = 0;
        while (prefixLen < len1 && prefixLen < len2 && s1.charAt(prefixLen) == s2.charAt(prefixLen)) {
            prefixLen++;
        }

        // Find the common suffix
        int suffixLen = 0;
        while (suffixLen < len1 && suffixLen < len2 && s1.charAt(len1 - suffixLen - 1) == s2.charAt(len2 - suffixLen - 1)) {
            suffixLen++;
        }

        // If there's a common prefix and suffix, try to extract a number from the middle
        if (prefixLen > 0 && suffixLen > 0) {
            String mid1 = s1.substring(prefixLen, len1 - suffixLen);
            String mid2 = s2.substring(prefixLen, len2 - suffixLen);

            Matcher numMatcher1 = NUMBER_PATTERN.matcher(mid1);
            Matcher numMatcher2 = NUMBER_PATTERN.matcher(mid2);

            if (numMatcher1.matches() && numMatcher2.matches()) {
                // Compare the numbers
                int num1 = Integer.parseInt(mid1);
                int num2 = Integer.parseInt(mid2);
                return Integer.compare(num1, num2);
            }
        }

        // Fall back to lexicographic comparison
        return s1.compareTo(s2);
    }

	public static void main(String[] args) {
	}
}