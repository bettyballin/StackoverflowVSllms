import java.util.Arrays;
import java.util.List;

public class EmailListSorter {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("smtp:user@domain.com", "smtp:user@otherdomain.com", "SMTP:user@anotherdomain.com");

        list.sort((s1, s2) -> {
            int c1 = s1.charAt(0);
            int c2 = s2.charAt(0);
            if (c1 < c2) return -1;
            else if (c1 > c2) return 1;
            else return s1.compareTo(s2);
        });

        System.out.println(list);
    }
}