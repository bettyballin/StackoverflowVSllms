/*
 * Decompiled with CFR 0.152.
 */
public class Sanitizer_8 {
    public static String sanitize(String string) {
        string = string.trim();
        string = string.replaceAll("<.*?>", "");
        string = string.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\"", "&quot;");
        return string;
    }

    public static void main(String[] stringArray) {
        System.out.println(Sanitizer_8.sanitize("Hello, <b>World</b>!"));
    }
}
