/*
 * Decompiled with CFR 0.152.
 */
public class Main_4 {
    public static String sanitize(String string) {
        string = string.trim();
        string = string.replace("'", "''");
        string = string.replace("\"", "\"\"");
        return string;
    }

    public static void main(String[] stringArray) {
        System.out.println(Main_4.sanitize("Hello, World!"));
    }
}
