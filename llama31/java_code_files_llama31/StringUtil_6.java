/*
 * Decompiled with CFR 0.152.
 */
public class StringUtil_6 {
    public static String padRight(String string, int n) {
        return String.format("%-" + n + "s", string);
    }

    public static String padLeft(String string, int n) {
        return String.format("%" + n + "s", string);
    }

    public static void main(String[] stringArray) {
        System.out.println(StringUtil_6.padRight("Hello", 10));
        System.out.println(StringUtil_6.padLeft("Hello", 10));
    }
}
