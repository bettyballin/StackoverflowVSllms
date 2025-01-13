/*
 * Decompiled with CFR 0.152.
 */
public class Sanitizer_6 {
    public static String sanitize(String string) {
        string = string.trim();
        string = string.replace("\\", "\\\\");
        string = string.replace("'", "\\'");
        string = string.replace("\"", "\\\"");
        return string;
    }

    public static void main(String[] stringArray) {
        String string = "   Some input with 'single quotes' and \"double quotes\"   ";
        System.out.println(Sanitizer_6.sanitize(string));
    }
}
