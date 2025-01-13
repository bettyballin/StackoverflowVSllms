/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;

public class Main_321 {
    public static void main(String[] stringArray) {
        int[] nArray = new int[]{1, 2, 3, 2, 1, 4, 5, 6, 2, 3};
        int n = 5;
        int[] nArray2 = UniqueExtractor.extractUniques(nArray, n);
        System.out.println(Arrays.toString(nArray2));
    }
}
