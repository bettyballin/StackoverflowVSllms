/*
 * Decompiled with CFR 0.152.
 */
import java.util.TreeSet;

public class NextSmallestLargest {
    private TreeSet<Integer> set = new TreeSet();

    public NextSmallestLargest(int[] nArray) {
        for (int n : nArray) {
            this.set.add(n);
        }
    }

    public int nextSmallest(int n) {
        return this.set.floor(n - 1);
    }

    public int nextLargest(int n) {
        return this.set.ceiling(n + 1);
    }

    public static void main(String[] stringArray) {
    }
}
