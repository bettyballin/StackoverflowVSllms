/*
 * Decompiled with CFR 0.152.
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlToPlainText {
    public static String htmlToPlainText(String string) {
        String string2 = "<.*?>";
        Pattern pattern = Pattern.compile(string2);
        Matcher matcher = pattern.matcher(string);
        return matcher.replaceAll("");
    }

    public static void main(String[] stringArray) {
        String string = "<p>This is a paragraph with <b>bold</b> text.</p>";
        System.out.println(HtmlToPlainText.htmlToPlainText(string));
    }
}
