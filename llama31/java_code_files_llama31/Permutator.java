/*
 * Decompiled with CFR 0.152.
 */
public class Permutator {
    public static void permute(int[] nArray) {
        int n = nArray.length;
        for (int i = n - 1; i > 0; --i) {
            int n2 = (int)(Math.random() * (double)(i + 1));
            int n3 = nArray[i];
            nArray[i] = nArray[n2];
            nArray[n2] = n3;
        }
    }

    public static void main(String[] stringArray) {
        int[] nArray = new int[]{3, 2, 0, 1};
        Permutator.permute(nArray);
        for (int i = 0; i < nArray.length; ++i) {
            System.out.print(nArray[i] + " ");
        }
    }
}
