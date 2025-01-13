/*
 * Decompiled with CFR 0.152.
 */
public class Sanitizer_5 {
    public static String sanitize(String string) {
        string = string.trim();
        return string;
    }

    public static void main(String[] stringArray) {
        System.out.println(Sanitizer_5.sanitize("   Hello, World!   "));
    }
}
