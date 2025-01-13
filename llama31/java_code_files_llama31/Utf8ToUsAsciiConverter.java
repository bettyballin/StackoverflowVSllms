/*
 * Decompiled with CFR 0.152.
 */
public class Utf8ToUsAsciiConverter {
    public static String convert(String string) {
        return string.replace("\u00c5", "A").replace("\u00e4", "a").replace("\u00f6", "o").replace("\u00fc", "u");
    }

    public static void main(String[] stringArray) {
        String string = "\u00c5\u00e4\u00f6\u00fc";
        String string2 = Utf8ToUsAsciiConverter.convert(string);
        System.out.println(string2);
    }
}
