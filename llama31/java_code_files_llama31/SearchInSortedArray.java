/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;
import java.util.Random;

public class SearchInSortedArray {
    public static void main(String[] stringArray) {
        int[] nArray = SearchInSortedArray.getSortedArray(10);
        int n = 7;
        int n2 = Arrays.binarySearch(nArray, n);
        System.out.println("Array is " + Arrays.toString(nArray));
        System.out.println("Index of " + n + " is " + n2);
    }

    private static int[] getSortedArray(int n) {
        int[] nArray = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; ++i) {
            nArray[i] = random.nextInt(n * 10);
        }
        Arrays.sort(nArray);
        return nArray;
    }
}
