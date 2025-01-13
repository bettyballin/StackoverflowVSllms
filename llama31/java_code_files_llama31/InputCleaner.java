/*
 * Decompiled with CFR 0.152.
 */
public class InputCleaner {
    public static void main(String[] stringArray) {
        String string = "Hello, World!";
        String string2 = string.replaceAll("\\P{L}+", "");
        System.out.println(string2);
    }
}
