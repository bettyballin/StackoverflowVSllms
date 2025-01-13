/*
 * Decompiled with CFR 0.152.
 */
public class IntArrayPermuter {
    public static void permute(int[] nArray) {
        int n = nArray.length;
        for (int i = 0; i < n; ++i) {
            int n2 = nArray[i];
            while (n2 < i) {
                int n3 = nArray[n2];
                nArray[n2] = nArray[i];
                nArray[i] = n3;
                n2 = nArray[i];
            }
        }
    }

    public static void main(String[] stringArray) {
        int[] nArray = new int[]{3, 1, 2, 0};
        System.out.println("Before permutation:");
        for (int n : nArray) {
            System.out.print(n + " ");
        }
        IntArrayPermuter.permute(nArray);
        System.out.println("\nAfter permutation:");
        for (int n : nArray) {
            System.out.print(n + " ");
        }
    }
}
