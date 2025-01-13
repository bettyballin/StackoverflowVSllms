/*
 * Decompiled with CFR 0.152.
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractHtmlData {
    public static void main(String[] stringArray) {
        String string;
        Pattern pattern = Pattern.compile("<span id=\"important-data\">(.*?)</span>");
        Matcher matcher = pattern.matcher(string = "// get the HTML content from the website");
        if (matcher.find()) {
            String string2 = matcher.group(1);
            System.out.println(string2);
        }
    }
}
