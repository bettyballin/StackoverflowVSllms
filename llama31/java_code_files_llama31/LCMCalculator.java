/*
 * Decompiled with CFR 0.152.
 */
public class LCMCalculator {
    public static int calculateLCM(int ... nArray) {
        int n = nArray[0];
        for (int i = 1; i < nArray.length; ++i) {
            n = n * nArray[i] / LCMCalculator.gcd(n, nArray[i]);
        }
        return n;
    }

    public static int gcd(int n, int n2) {
        if (n2 == 0) {
            return n;
        }
        return LCMCalculator.gcd(n2, n % n2);
    }

    public static void main(String[] stringArray) {
        int[] nArray = new int[]{2, 3, 4, 5};
        int n = LCMCalculator.calculateLCM(nArray);
        System.out.println("LCM: " + n);
    }
}
