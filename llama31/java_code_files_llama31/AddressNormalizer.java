/*
 * Decompiled with CFR 0.152.
 */
public class AddressNormalizer {
    public static void main(String[] stringArray) {
        String[] stringArray2;
        String string = "Quellenstrasse 66/11";
        int n = 2;
        for (String string2 : stringArray2 = new String[]{"Quellenstrasse 66/10", "Quellenstrasse 67/11", "Quellenstrasse 66/11"}) {
            int n2 = AddressNormalizer.levenshteinDistance(string, string2);
            if (n2 > n) continue;
            System.out.println("Similar address found: " + string2 + ". Distance: " + n2);
        }
    }

    public static int levenshteinDistance(String string, String string2) {
        int[] nArray = new int[string2.length() + 1];
        for (int i = 0; i <= string.length(); ++i) {
            int n = i;
            for (int j = 0; j <= string2.length(); ++j) {
                if (i == 0) {
                    nArray[j] = j;
                    continue;
                }
                if (j <= 0) continue;
                int n2 = nArray[j - 1];
                if (string.charAt(i - 1) != string2.charAt(j - 1)) {
                    n2 = Math.min(Math.min(n2, n), nArray[j]) + 1;
                }
                nArray[j - 1] = n;
                n = n2;
            }
            if (i <= 0) continue;
            nArray[string2.length()] = n;
        }
        return nArray[string2.length()];
    }
}
