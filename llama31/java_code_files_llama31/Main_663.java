/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;

public class Main_663 {
    public static void main(String[] stringArray) {
        int[] nArray = new int[]{45, 89, 22, 31, 23, 76};
        int[] nArray2 = new int[]{5, 3, 2, 1, 0, 4};
        Main_663.permute(nArray, nArray2);
        System.out.println(Arrays.toString(nArray));
    }

    public static void permute(int[] nArray, int[] nArray2) {
        int[] nArray3 = new int[nArray.length];
        for (int i = 0; i < nArray.length; ++i) {
            nArray3[i] = nArray[nArray2[i]];
        }
        System.arraycopy(nArray3, 0, nArray, 0, nArray.length);
    }
}
