/*
 * Decompiled with CFR 0.152.
 */
public class StringSanitizer {
    public static String removeNonAlphanumeric(String string) {
        return string.replaceAll("[^a-zA-Z0-9\\s]", "");
    }

    public static void main(String[] stringArray) {
        System.out.println(StringSanitizer.removeNonAlphanumeric("Hello, World!"));
    }
}
