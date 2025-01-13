/*
 * Decompiled with CFR 0.152.
 */
import java.util.regex.Pattern;

public class HtmlSelectExtractor {
    String pattern = "<select[^>]*>(.*?)</select>";

    public HtmlSelectExtractor() {
        Pattern.compile(this.pattern, 42);
    }

    public static void main(String[] stringArray) {
        new HtmlSelectExtractor();
    }
}
