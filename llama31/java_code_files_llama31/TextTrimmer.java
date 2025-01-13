/*
 * Decompiled with CFR 0.152.
 */
public class TextTrimmer {
    public static String trimToNearestWord(String string, int n) {
        if (string.length() <= n) {
            return string;
        }
        int n2 = string.lastIndexOf(32, n);
        if (n2 == -1) {
            return string.substring(0, n);
        }
        return string.substring(0, n2);
    }

    public static void main(String[] stringArray) {
        String string = "This is a block of text, blah blah blah";
        String string2 = "this is another block of txt 2 work with";
        int n = 27;
        System.out.println(TextTrimmer.trimToNearestWord(string, n));
        System.out.println(TextTrimmer.trimToNearestWord(string2, n));
    }
}
