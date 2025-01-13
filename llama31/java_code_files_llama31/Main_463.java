/*
 * Decompiled with CFR 0.152.
 */
public class Main_463 {
    public static void main(String[] stringArray) {
        String string = "Robert";
        String string2 = "Amy Robertson";
        String string3 = "Richard";
        System.out.println(Main_463.strSimilarity(string, string2));
        System.out.println(Main_463.strSimilarity(string, string3));
    }

    public static int strSimilarity(String string, String string2) {
        int n = 0;
        int n2 = Math.min(string.length(), string2.length());
        int n3 = Math.max(string.length(), string2.length());
        for (int i = 0; i < n2 && string.charAt(i) == string2.charAt(i); ++i) {
            ++n;
        }
        return n * 100 / n3;
    }
}
