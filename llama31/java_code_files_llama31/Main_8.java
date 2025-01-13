/*
 * Decompiled with CFR 0.152.
 */
public class Main_8 {
    public static String sanitize(String string) {
        string = string.trim();
        string = string.replace("\\", "\\\\");
        string = string.replace("'", "\\'");
        string = string.replace("\"", "\\\"");
        return string;
    }

    public static void main(String[] stringArray) {
        String string = "Hello, World!";
        System.out.println(Main_8.sanitize(string));
    }
}
