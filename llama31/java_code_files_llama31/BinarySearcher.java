/*
 * Decompiled with CFR 0.152.
 */
public class BinarySearcher {
    public static int searchInSortedArray(int[] nArray, int n) {
        int n2 = 0;
        int n3 = nArray.length - 1;
        while (n2 <= n3) {
            int n4 = n2 + (n3 - n2) / 2;
            if (nArray[n4] == n) {
                return n4;
            }
            if (nArray[n4] < n) {
                n2 = n4 + 1;
                continue;
            }
            if (nArray[n4] <= n) continue;
            n3 = n4 - 1;
        }
        return -1;
    }

    public static void main(String[] stringArray) {
        int[] nArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int n = 5;
        int n2 = BinarySearcher.searchInSortedArray(nArray, n);
        System.out.println("Target found at index " + n2);
    }
}
