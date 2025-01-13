/*
 * Decompiled with CFR 0.152.
 */
public class SingleNumberFinder {
    public int findSingleNumber(int[] nArray) {
        int n = 0;
        for (int n2 : nArray) {
            n ^= n2;
        }
        return n;
    }

    public static void main(String[] stringArray) {
        SingleNumberFinder singleNumberFinder = new SingleNumberFinder();
        int[] nArray = new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4};
        System.out.println("Single number: " + singleNumberFinder.findSingleNumber(nArray));
    }
}
