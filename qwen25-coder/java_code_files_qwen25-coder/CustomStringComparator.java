import java.lang.String;
import java.lang.Integer;
import java.util.Comparator;

public class CustomStringComparator implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        // Extract numeric parts from both strings
        Integer num1 = extractMiddleNumber(s1);
        Integer num2 = extractMiddleNumber(s2);

        // Compare based on the extracted numbers if possible
        if (num1 != null && num2 != null) {
            return num1.compareTo(num2);
        }

        // If one or both are not numeric in the middle, fall back to lexical comparison
        return s1.compareTo(s2);
    }

    private Integer extractMiddleNumber(String str) {
        int prefixLength = 0;
        int suffixLength = 0;

        // Determine the common prefix length
        for (int i = 0; i < Math.min(str.length(), "bbb xxx ccc".length()) - 1; i++) {
            if (str.charAt(i) == "bbb xxx ccc".charAt(i)) {
                prefixLength++;
            } else {
                break;
            }
        }

        // Determine the common suffix length
        for (int i = 0; i < Math.min(str.length(), "bbb xxx ccc".length()) - 1; i++) {
            if (str.charAt(str.length() - 1 - i) == "bbb xxx ccc".charAt("bbb xxx ccc".length() - 1 - i)) {
                suffixLength++;
            } else {
                break;
            }
        }

        // Extract the potential middle part and check if it's a number
        String middlePart = str.substring(prefixLength, str.length() - suffixLength).trim();
        try {
            return Integer.parseInt(middlePart);
        } catch (NumberFormatException e) {
            return null; // If not a number, return null to indicate no numeric comparison possible
        }
    }

    public static void main(String[] args) {
        String[] strings = {"aaa", "bbb 3 ccc", "bbb 12 ccc", "ccc 11", "ddd", "eee 3 ddd jpeg2000 eee", "eee 12 ddd jpeg2000 eee"};
        
        java.util.Arrays.sort(strings, new CustomStringComparator());
        
        for (String s : strings) {
            System.out.println(s);
        }
    }
}