/*
 * Decompiled with CFR 0.152.
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MixedCharWordMatcher {
    public static void main(String[] stringArray) {
        String string = "fr1&nd$ friends";
        Pattern pattern = Pattern.compile("\\b(?=\\w*[a-zA-Z])(?=\\w*[^\\w\\s])\\w+\\b");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
