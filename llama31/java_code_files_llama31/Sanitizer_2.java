/*
 * Decompiled with CFR 0.152.
 */
public class Sanitizer_2 {
    public static String sanitize(String string) {
        string = string.trim();
        string = string.replace("'", "\\'").replace("\"", "\\\"").replace("\\", "\\\\");
        return string;
    }

    public static void main(String[] stringArray) {
        System.out.println(Sanitizer_2.sanitize("Hello 'World'!"));
    }
}
