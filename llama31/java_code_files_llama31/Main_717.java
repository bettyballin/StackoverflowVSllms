/*
 * Decompiled with CFR 0.152.
 */
public class Main_717 {
    public static void main(String[] stringArray) {
        String string = "Example User Input";
        String string2 = Main_717.escapeHtml(string);
        System.out.println(string2);
    }

    private static String escapeHtml(String string) {
        return string.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\"", "&quot;").replaceAll("'", "&#x27;");
    }
}
