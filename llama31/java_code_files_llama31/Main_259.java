/*
 * Decompiled with CFR 0.152.
 */
public class Main_259 {
    public static void main(String[] stringArray) {
        String string = "my string";
        String string2 = Main_259.reverseWords(string);
        System.out.println(string2);
    }

    public static String reverseWords(String string) {
        CharSequence[] charSequenceArray = string.split(" ");
        for (int i = 0; i < charSequenceArray.length; ++i) {
            charSequenceArray[i] = new StringBuilder((String)charSequenceArray[i]).reverse().toString();
        }
        return String.join((CharSequence)" ", charSequenceArray);
    }
}
