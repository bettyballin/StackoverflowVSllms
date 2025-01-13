/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;

public class FindDupsAndMissed {
    public static void main(String[] stringArray) {
        int[] nArray = new int[]{4, 5, 5, 5, 7, 8, 9, 10, 10};
        int[] nArray2 = new int[11];
        int[] nArray3 = new int[11];
        int n = 0;
        int n2 = 0;
        for (int i = 0; i < nArray.length; ++i) {
            if (nArray[i] - i != 3) {
                nArray2[n++] = i + 3;
            }
            if (nArray[i] - i <= 3) continue;
            nArray3[n2++] = i + 3;
        }
        System.out.println("Array: " + Arrays.toString(nArray));
        System.out.println("Missed: " + Arrays.toString(Arrays.copyOf(nArray2, n)));
        System.out.println("Duplicates: " + Arrays.toString(Arrays.copyOf(nArray3, n2)));
    }
}
