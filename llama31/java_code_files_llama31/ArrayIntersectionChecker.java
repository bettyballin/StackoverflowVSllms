/*
 * Decompiled with CFR 0.152.
 */
public class ArrayIntersectionChecker {
    public static boolean intersect(int[] nArray, int[] nArray2) {
        int n = 0;
        int n2 = 0;
        while (n < nArray.length && n2 < nArray2.length) {
            if (nArray[n] < nArray2[n2]) {
                ++n;
                continue;
            }
            if (nArray[n] > nArray2[n2]) {
                ++n2;
                continue;
            }
            return true;
        }
        return false;
    }

    public static void main(String[] stringArray) {
        int[] nArray = new int[]{1, 2, 3, 4, 5};
        int[] nArray2 = new int[]{4, 5, 6, 7, 8};
        System.out.println("Do arrays intersect? " + ArrayIntersectionChecker.intersect(nArray, nArray2));
    }
}
