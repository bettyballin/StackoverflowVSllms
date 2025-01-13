/*
 * Decompiled with CFR 0.152.
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sanitizer_7 {
    public static String sanitize(String string) {
        string = string.trim();
        string = string.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;").replace("'", "&#x27;");
        Pattern pattern = Pattern.compile("<.*?>");
        Matcher matcher = pattern.matcher(string);
        string = matcher.replaceAll("");
        return string;
    }

    public static void main(String[] stringArray) {
        System.out.println(Sanitizer_7.sanitize("Hello <b>World</b>!"));
    }
}
