/*
 * Decompiled with CFR 0.152.
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelloWorld_67 {
    public static void main(String[] stringArray) {
        String string = "<p>How to retrieve the text between two html markup with c# ?</p>";
        String string2 = "<p>(.*?)</p>";
        Pattern pattern = Pattern.compile(string2);
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }
}
