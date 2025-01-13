/*
 * Decompiled with CFR 0.152.
 */
public class SentenceFormatter {
    public static void main(String[] stringArray) {
        String string = "Yesterday, I saw a %s eating a %s in the %s.";
        String string2 = "dog";
        String string3 = "bone";
        String string4 = "park";
        String string5 = String.format(string, string2, string3, string4);
        System.out.println(string5);
    }
}
