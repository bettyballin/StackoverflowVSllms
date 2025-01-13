/*
 * Decompiled with CFR 0.152.
 */
public class Sanitizer_14 {
    public static String sanitize(String string) {
        return string.trim().replaceAll("\\<.*?\\>", "");
    }

    public static void main(String[] stringArray) {
        System.out.println(Sanitizer_14.sanitize("   Hello, <b>World!</b>   "));
    }
}
