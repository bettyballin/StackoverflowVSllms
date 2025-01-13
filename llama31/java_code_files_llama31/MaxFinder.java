/*
 * Decompiled with CFR 0.152.
 */
public class MaxFinder {
    public static int findMax(int[] nArray) {
        int n = nArray[0];
        for (int i = 1; i < nArray.length; ++i) {
            if (nArray[i] <= n) continue;
            n = nArray[i];
        }
        return n;
    }

    public static void main(String[] stringArray) {
        int[] nArray = new int[]{1, 2, 3, 4, 5};
        System.out.println("Max value: " + MaxFinder.findMax(nArray));
    }
}
