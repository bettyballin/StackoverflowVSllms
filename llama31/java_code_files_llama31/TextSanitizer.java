/*
 * Decompiled with CFR 0.152.
 */
public class TextSanitizer {
    public static void main(String[] stringArray) {
        String string = "i like cats\n\n\nmy cat is happy\ni love my cat\n\n\n\nhope you have a nice day\n";
        String string2 = string.replaceAll("\n{2,}", "\n\n");
        System.out.println(string2);
    }
}
