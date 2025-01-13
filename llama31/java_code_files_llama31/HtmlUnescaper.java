/*
 * Decompiled with CFR 0.152.
 */
public class HtmlUnescaper {
    public static void main(String[] stringArray) {
        String string = "&lt;p&gt;This is a paragraph of text.&lt;/p&gt;";
        String string2 = HtmlUnescaper.unescapeHtml(string);
        System.out.println("Unescaped Description:");
        System.out.println(string2);
    }

    private static String unescapeHtml(String string) {
        return string.replace("&lt;", "<").replace("&gt;", ">");
    }
}
