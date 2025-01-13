/*
 * Decompiled with CFR 0.152.
 */
public class XSSSanitizer {
    private static final String XSS_PATTERN = "\\b((?!(?:[^<>]*\\/>|[^>]*<\\/))(?:\\w+\\s*=\\s*(?:\".*?\"|'.*?'|[^>\\s]+)|\\w+\\s*=\\s*|\\w+\\s*=|\\s*\\w+\\s*=\\s*(?:\".*?\"|'.*?'|[^>\\s]+))+)";

    public static String sanitize(String string) {
        return string.replaceAll(XSS_PATTERN, "");
    }

    public static void main(String[] stringArray) {
        String string = "<script>alert('XSS')</script>";
        String string2 = XSSSanitizer.sanitize(string);
        System.out.println(string2);
    }
}
