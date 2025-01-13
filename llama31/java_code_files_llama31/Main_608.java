/*
 * Decompiled with CFR 0.152.
 */
public class Main_608 {
    public static void main(String[] stringArray) {
        int[] nArray = new int[]{5, 2, 8, 12, 3};
        Main_608.sortList(nArray);
        for (int n : nArray) {
            System.out.print(n + " ");
        }
    }

    public static void sortList(int[] nArray) {
        for (int i = 0; i < nArray.length; ++i) {
            for (int j = i + 1; j < nArray.length; ++j) {
                if (nArray[i] <= nArray[j]) continue;
                int n = nArray[i];
                nArray[i] = nArray[j];
                nArray[j] = n;
            }
        }
    }
}
