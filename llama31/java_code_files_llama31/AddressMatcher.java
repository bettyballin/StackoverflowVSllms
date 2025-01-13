/*
 * Decompiled with CFR 0.152.
 */
public class AddressMatcher {
    public static int levenshteinDistance(String string, String string2) {
        int n;
        int[] nArray = new int[string2.length() + 1];
        for (n = 0; n < nArray.length; ++n) {
            nArray[n] = n;
        }
        for (n = 1; n <= string.length(); ++n) {
            nArray[0] = n;
            int n2 = n - 1;
            for (int i = 1; i <= string2.length(); ++i) {
                int n3 = Math.min(1 + Math.min(nArray[i], nArray[i - 1]), string.charAt(n - 1) == string2.charAt(i - 1) ? n2 : n2 + 1);
                n2 = nArray[i];
                nArray[i] = n3;
            }
        }
        return nArray[string2.length()];
    }

    public static boolean isSimilar(String string, String string2) {
        int n = AddressMatcher.levenshteinDistance(string, string2);
        return n <= 2;
    }

    public static void main(String[] stringArray) {
    }
}
