/*
 * Decompiled with CFR 0.152.
 */
public class YahtzeeChecker {
    public boolean hasSmallStraight(int[] nArray) {
        int[] nArray2 = new int[7];
        int[] nArray3 = nArray;
        int n = nArray3.length;
        for (int i = 0; i < n; ++i) {
            int n2;
            int n3 = n2 = nArray3[i];
            nArray2[n3] = nArray2[n3] + 1;
        }
        for (int i = 1; i <= 3; ++i) {
            if (nArray2[i] <= 0 || nArray2[i + 1] <= 0 || nArray2[i + 2] <= 0 || nArray2[i + 3] <= 0) continue;
            return true;
        }
        return false;
    }

    public static void main(String[] stringArray) {
        YahtzeeChecker yahtzeeChecker = new YahtzeeChecker();
        int[] nArray = new int[]{1, 2, 3, 4, 5};
        System.out.println(yahtzeeChecker.hasSmallStraight(nArray));
    }
}
