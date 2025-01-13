/*
 * Decompiled with CFR 0.152.
 */
public class Sanitizer_17 {
    public static String sanitize(String string) {
        string = string.trim();
        string = string.replace("'", "\\'");
        return string;
    }

    public static void main(String[] stringArray) {
        String string = "Hello, World!";
        System.out.println(Sanitizer_17.sanitize(string));
    }
}
