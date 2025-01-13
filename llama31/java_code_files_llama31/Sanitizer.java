/*
 * Decompiled with CFR 0.152.
 */
public class Sanitizer {
    public static String sanitize(String string) {
        string = string.trim();
        string = string.replace("'", "''");
        string = string.replace("\\", "\\\\");
        return string;
    }

    public static void main(String[] stringArray) {
        System.out.println(Sanitizer.sanitize("Hello, World!"));
    }
}
