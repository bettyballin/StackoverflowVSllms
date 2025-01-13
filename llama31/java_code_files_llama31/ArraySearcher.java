/*
 * Decompiled with CFR 0.152.
 */
public class ArraySearcher {
    public static int findElement(int[] nArray, int n) {
        for (int i = 0; i < nArray.length; ++i) {
            if (nArray[i] != n) continue;
            return i;
        }
        return -1;
    }

    public static void main(String[] stringArray) {
        int[] nArray = new int[]{1, 2, 3, 4, 5};
        int n = 3;
        int n2 = ArraySearcher.findElement(nArray, n);
        System.out.println("Element found at index: " + n2);
    }
}
