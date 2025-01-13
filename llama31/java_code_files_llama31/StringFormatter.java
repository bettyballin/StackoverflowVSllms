/*
 * Decompiled with CFR 0.152.
 */
public class StringFormatter {
    public static void main(String[] stringArray) {
        String string = "John";
        String string2 = String.format("Hello, %s!", string);
        System.out.println(string2);
    }
}
