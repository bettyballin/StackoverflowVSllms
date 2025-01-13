/*
 * Decompiled with CFR 0.152.
 */
public class Main_535 {
    public static void main(String[] stringArray) {
        String string = "<html><body><a href='https://example.com'>Example</a></body></html>";
        int n = string.indexOf("<a href=");
        int n2 = string.indexOf("</a>");
        if (n != -1 && n2 != -1) {
            String string2 = string.substring(n, n2 + 4);
            System.out.println("Extracted <a> tag: " + string2);
        } else {
            System.out.println("No <a> tags found.");
        }
    }
}
