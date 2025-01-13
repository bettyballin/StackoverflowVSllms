/*
 * Decompiled with CFR 0.152.
 */
public class HtmlFilePathSanitizer {
    public static String sanitizeHtmlFilePath(String string) {
        return string.replaceAll("[^a-zA-Z0-9._-]", "");
    }

    public static void main(String[] stringArray) {
        String string = "/path/to/your/html/file.html";
        String string2 = HtmlFilePathSanitizer.sanitizeHtmlFilePath(string);
        System.out.println(string2);
    }
}
