import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByCase {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("smtp:user@domain.com");
        list.add("smtp:user@otherdomain.com");
        list.add("SMTP:user@anotherdomain.com");

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // Compare based on case sensitivity by using an inverted comparison of lowercase strings
                return Boolean.compare(Character.isUpperCase(s1.charAt(0)), Character.isUpperCase(s2.charAt(0)));
            }
        });

        for (String s : list) {
            System.out.println(s);
        }
    }
}