/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;
import java.util.Random;

public class ParallelSortExample {
    public static void main(String[] stringArray) {
        int[] nArray = new Random().ints(1000000L, 0, 1000000).toArray();
        Arrays.parallelSort(nArray);
        System.out.println(Arrays.toString(nArray));
    }
}
