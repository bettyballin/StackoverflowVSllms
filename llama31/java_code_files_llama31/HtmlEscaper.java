/*
 * Decompiled with CFR 0.152.
 */
public class HtmlEscaper {
    public static void main(String[] stringArray) {
        if (stringArray.length != 2) {
            System.out.println("Usage: java HtmlEscaper <sender> <text>");
            System.exit(0);
        }
        String string = HtmlEscaper.escapeHtml(stringArray[0]);
        String string2 = HtmlEscaper.escapeHtml(stringArray[1]);
        System.out.println("Sender: " + string);
        System.out.println("Text: " + string2);
    }

    public static String escapeHtml(String string) {
        if (string == null) {
            return null;
        }
        return string.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\"", "&quot;").replaceAll("'", "&#x27;");
    }
}
