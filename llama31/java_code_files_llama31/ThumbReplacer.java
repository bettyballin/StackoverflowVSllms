/*
 * Decompiled with CFR 0.152.
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ThumbReplacer {
    public static String replaceThumbs(String string, String[] stringArray) {
        Pattern pattern = Pattern.compile("\\[thumb(\\d+)\\]");
        Matcher matcher = pattern.matcher(string);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String string2 = "<img src=\"thumbs/" + stringArray[Integer.parseInt(matcher.group(1))] + "\">";
            matcher.appendReplacement(stringBuffer, string2);
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public static void main(String[] stringArray) {
    }
}
