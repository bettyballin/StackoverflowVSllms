import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class CaseInsensitiveSorter {
    public static void main(String[] args) {
        List<String> list = Arrays.asList(
            "SMTP:user@anotherdomain.com",
            "smtp:user@otherdomain.com",
            "smtp:user@domain.com"
        );
        Collections.sort(list, (s1, s2) -> {
            if (Character.isLowerCase(s1.charAt(0)) && Character.isUpperCase(s2.charAt(0))) return 1;
            else if (Character.isUpperCase(s1.charAt(0)) && Character.isLowerCase(s2.charAt(0))) return -1;
            return s1.compareToIgnoreCase(s2);
        });
        list.forEach(System.out::println);
    }
}