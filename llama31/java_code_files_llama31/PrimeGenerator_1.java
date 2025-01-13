/*
 * Decompiled with CFR 0.152.
 */
public class PrimeGenerator_1 {
    public static void main(String[] stringArray) {
        int n;
        int n2;
        int n3 = 10000;
        boolean[] blArray = new boolean[n3 * 15];
        for (n2 = 2; n2 < blArray.length; ++n2) {
            blArray[n2] = true;
        }
        n2 = 2;
        while (n2 * n2 < blArray.length) {
            if (blArray[n2]) {
                for (n = n2 * n2; n < blArray.length; n += n2) {
                    blArray[n] = false;
                }
            }
            ++n2;
        }
        n2 = 0;
        for (n = 2; n < blArray.length && n2 < n3; ++n) {
            if (!blArray[n]) continue;
            System.out.println(n);
            ++n2;
        }
    }
}
