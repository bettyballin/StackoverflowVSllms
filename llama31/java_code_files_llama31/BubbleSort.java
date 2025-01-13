/*
 * Decompiled with CFR 0.152.
 */
public class BubbleSort {
    public static void bubbleSort(int[] nArray) {
        int n = nArray.length;
        for (int i = 0; i < n - 1; ++i) {
            for (int j = 0; j < n - i - 1; ++j) {
                if (nArray[j] <= nArray[j + 1]) continue;
                int n2 = nArray[j];
                nArray[j] = nArray[j + 1];
                nArray[j + 1] = n2;
            }
        }
    }

    public static void main(String[] stringArray) {
        int[] nArray = new int[]{64, 34, 25, 12, 22, 11, 90};
        BubbleSort.bubbleSort(nArray);
        System.out.println("Sorted array:");
        for (int i = 0; i < nArray.length; ++i) {
            System.out.print(nArray[i] + " ");
        }
    }
}
