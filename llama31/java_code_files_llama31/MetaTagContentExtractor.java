/*
 * Decompiled with CFR 0.152.
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MetaTagContentExtractor {
    public static void main(String[] stringArray) {
        String string = "<meta content='blogger' name='generator'/>";
        String string2 = "<meta name=\"generator\" content=\"WordPress.com\" />";
        Pattern pattern = Pattern.compile("<meta\\s+[^>]*content\\s*=\\s*[\"'](.*?)[\"'][^>]*>", 2);
        Matcher matcher = pattern.matcher(string);
        Matcher matcher2 = pattern.matcher(string2);
        if (matcher.find()) {
            System.out.println("Content from html1: " + matcher.group(1));
        }
        if (matcher2.find()) {
            System.out.println("Content from html2: " + matcher2.group(1));
        }
    }
}
