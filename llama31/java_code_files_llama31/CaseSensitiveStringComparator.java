/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CaseSensitiveStringComparator {
    public static void main(String[] stringArray) {
        List<String> list = Arrays.asList("smtp:user@domain.com", "smtp:user@otherdomain.com", "SMTP:user@anotherdomain.com");
        Collections.sort(list, new Comparator<String>(){

            @Override
            public int compare(String string, String string2) {
                char c;
                char c2 = string.charAt(0);
                if (c2 < (c = string2.charAt(0))) {
                    return -1;
                }
                if (c2 > c) {
                    return 1;
                }
                return string.compareTo(string2);
            }
        });
        System.out.println(list);
    }
}
