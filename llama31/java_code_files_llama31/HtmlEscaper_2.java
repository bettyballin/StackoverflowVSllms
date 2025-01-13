/*
 * Decompiled with CFR 0.152.
 */
public class HtmlEscaper_2 {
    public static String escapeHtml(String string) {
        return string.replace("<", "&lt;").replace(">", "&gt;");
    }

    public static void main(String[] stringArray) {
        String string = "<script>alert('XSS')</script>";
        System.out.println(HtmlEscaper_2.escapeHtml(string));
    }
}
