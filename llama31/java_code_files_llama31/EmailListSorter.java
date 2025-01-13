/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;
import java.util.List;

public class EmailListSorter {
    public static void main(String[] stringArray) {
        List<String> list = Arrays.asList("smtp:user@domain.com", "smtp:user@otherdomain.com", "SMTP:user@anotherdomain.com");
        list.sort((string, string2) -> {
            char c;
            char c2 = string.charAt(0);
            if (c2 < (c = string2.charAt(0))) {
                return -1;
            }
            if (c2 > c) {
                return 1;
            }
            return string.compareTo((String)string2);
        });
        System.out.println(list);
    }
}
