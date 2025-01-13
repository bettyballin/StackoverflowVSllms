/*
 * Decompiled with CFR 0.152.
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlTagSplitter {
    public static void main(String[] stringArray) {
        String string = "<b>Bold</b> This is the stuff <i>Italic</i>";
        Pattern pattern = Pattern.compile("(<[^>]*>|[^<>]+)");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
