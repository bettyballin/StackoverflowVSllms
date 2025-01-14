import java.lang.String;
import java.lang.Integer;
import java.util.Arrays;
import java.util.Comparator;

public class NaturalOrderComparator implements Comparator<String> {
    public int compare(String s1, String s2) {
        if (s1 == null && s2 == null) return 0;
        if (s1 == null) return -1;
        if (s2 == null) return 1;

        boolean isDigitS1 = Character.isDigit(s1.charAt(0));
        boolean isDigitS2 = Character.isDigit(s2.charAt(0));

        if(isDigitS1 && isDigitS2) {
            int val1 = Integer.parseInt(s1.split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)", 2)[0]);
            int val2 = Integer.parseInt(s2.split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)", 2)[0]);

            if(val1 != val2) return val1 - val2;

            s1 = s1.substring(String.valueOf(val1).length());
            s2 = s2.substring(String.valueOf(val2).length());
        }

        if(!isDigitS1 && !isDigitS2) {
            int cmp = s1.compareTo(s2);
            if(cmp != 0) return cmp;

            s1 = s1.substring(1);
            s2 = s2.substring(1);
        }
        
        // Recursively compare the rest of the strings
        return compare(s1, s2);
    }

    public static void main(String[] args) {
        String[] versions = {"1.2.9.1", "1.2.10.5"};
        
        Arrays.sort(versions, new NaturalOrderComparator());
        
        System.out.println(Arrays.toString(versions));
    }
}