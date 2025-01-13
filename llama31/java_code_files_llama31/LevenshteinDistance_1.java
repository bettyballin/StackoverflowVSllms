/*
 * Decompiled with CFR 0.152.
 */
public class LevenshteinDistance_1 {
    public static int distance(String string, String string2) {
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

    public static void main(String[] stringArray) {
        String string = "Into the clear blue sky";
        String string2 = "The color is sky blue";
        String string3 = "In the blue clear sky";
        System.out.println("Distance between s1 and s2: " + LevenshteinDistance_1.distance(string, string2));
        System.out.println("Distance between s1 and s3: " + LevenshteinDistance_1.distance(string, string3));
    }
}
