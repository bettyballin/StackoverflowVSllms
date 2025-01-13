/*
 * Decompiled with CFR 0.152.
 */
public class Sanitizer_13 {
    public static String sanitize(String string) {
        return string.trim().replaceAll("<.*?>", "");
    }

    public static void main(String[] stringArray) {
        String string = "<p>Hello, World!</p>";
        System.out.println(Sanitizer_13.sanitize(string));
    }
}
