/*
 * Decompiled with CFR 0.152.
 */
public class ArrayPermuter {
    public static void permute(int[] nArray, int[] nArray2) {
        for (int i = 0; i < nArray.length; ++i) {
            while (nArray2[i] != i) {
                int n = nArray[i];
                nArray[i] = nArray[nArray2[i]];
                nArray[nArray2[i]] = n;
                int n2 = nArray2[i];
                nArray2[i] = nArray2[n2];
                nArray2[n2] = n2;
            }
        }
    }

    public static void main(String[] stringArray) {
    }
}
