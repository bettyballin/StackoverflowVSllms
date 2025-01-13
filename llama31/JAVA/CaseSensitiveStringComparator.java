import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CaseSensitiveStringComparator {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("smtp:user@domain.com", "smtp:user@otherdomain.com", "SMTP:user@anotherdomain.com");

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // Compare the ASCII value of the first character of each string
                int c1 = s1.charAt(0);
                int c2 = s2.charAt(0);

                // Uppercase letters have lower ASCII values than lowercase letters
                if (c1 < c2) {
                    return -1; // s1 comes first
                } else if (c1 > c2) {
                    return 1; // s2 comes first
                } else {
                    // If the case is the same, compare the rest of the string
                    return s1.compareTo(s2);
                }
            }
        });

        System.out.println(list);
    }
}