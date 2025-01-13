/*
 * Decompiled with CFR 0.152.
 */
public class BinarySearch {
    public static int findMatch(byte[] byArray, int[] nArray) {
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        for (int n4 : nArray) {
            int n5 = 32 - Integer.numberOfLeadingZeros(n4);
            int n6 = 0;
            while (n5 > 0) {
                int n7 = 8 - n2;
                int n8 = Math.min(n7, n5);
                int n9 = (1 << n8) - 1;
                n6 |= (byArray[n] >>> 8 - n2 - n8 & n9) << n5 - n8;
                n5 -= n8;
                if ((n2 += n8) != 8) continue;
                ++n;
                n2 = 0;
            }
            if (n6 == n4) {
                return n3;
            }
            ++n3;
        }
        return -1;
    }

    public static void main(String[] stringArray) {
        byte[] byArray = new byte[]{-88, -30, 97, 87, 113, 86};
        int[] nArray = new int[]{10, 4, 6, 14};
        int n = BinarySearch.findMatch(byArray, nArray);
        if (n != -1) {
            System.out.println("Match found at index " + n);
        } else {
            System.out.println("No match found");
        }
    }
}
