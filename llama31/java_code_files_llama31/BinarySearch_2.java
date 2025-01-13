/*
 * Decompiled with CFR 0.152.
 */
public class BinarySearch_2 {
    public static int search(int[] nArray, int n) {
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
            n3 = n4 - 1;
        }
        return -1;
    }

    public static void main(String[] stringArray) {
        int[] nArray = new int[]{2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int n = 23;
        int n2 = BinarySearch_2.search(nArray, n);
        if (n2 != -1) {
            System.out.println("Element found at index " + n2);
        } else {
            System.out.println("Element not found");
        }
    }
}
