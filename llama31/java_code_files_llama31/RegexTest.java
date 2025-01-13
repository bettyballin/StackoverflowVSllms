/*
 * Decompiled with CFR 0.152.
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    public static void main(String[] stringArray) {
        String[] stringArray2 = new String[]{"785*()&!~`a", "##$%$~2343", "455frt&*&*"};
        Pattern pattern = Pattern.compile(".*[a-zA-Z].*");
        for (String string : stringArray2) {
            Matcher matcher = pattern.matcher(string);
            if (!matcher.matches()) continue;
            System.out.println("Match: " + string);
        }
    }
}
