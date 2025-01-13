/*
 * Decompiled with CFR 0.152.
 */
public class HammingDistanceCalculator {
    public static int minHamming(String string, String string2) {
        int n;
        int n2 = string.length();
        int n3 = string2.length();
        int n4 = (1 << n3) - 1;
        int[] nArray = new int[n2 + 1];
        for (n = 0; n < n2; ++n) {
            nArray[n + 1] = nArray[n] << 1 | (string.charAt(n) == string2.charAt(0) ? 1 : 0);
        }
        n = n3;
        for (int i = n3 - 1; i < n2; ++i) {
            int n5 = (nArray[i + 1] ^ n4 << i - n3 + 1) & n4;
            int n6 = Integer.bitCount(n5);
            if (n6 >= n) continue;
            n = n6;
        }
        return n;
    }

    public static void main(String[] stringArray) {
        System.out.println(HammingDistanceCalculator.minHamming("abcde", "abc"));
    }
}
