/*
 * Decompiled with CFR 0.152.
 */
public class Sanitizer_1 {
    public static String sanitize(String string) {
        string = string.trim();
        string = string.replace("'", "''");
        return string;
    }

    public static void main(String[] stringArray) {
        String string = "Hello, World!";
        System.out.println(Sanitizer_1.sanitize(string));
    }
}
