/*
 * Decompiled with CFR 0.152.
 */
public class StringBuilderUtil {
    public static String append(String string, String string2) {
        return String.valueOf(string) + string2;
    }

    public static void main(String[] stringArray) {
        String string = "Hello";
        String string2 = " World";
        System.out.println(StringBuilderUtil.append(string, string2));
    }
}
