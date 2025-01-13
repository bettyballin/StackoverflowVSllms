/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashSet;

public class SmallestMissingInteger {
    public static int findSmallestMissingInteger(int[] nArray) {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int n : nArray) {
            hashSet.add(n);
        }
        int n = 0;
        while (hashSet.contains(n)) {
            ++n;
        }
        return n;
    }

    public static void main(String[] stringArray) {
        int[] nArray = new int[]{0, 1, 3, 4, 7};
        System.out.println(SmallestMissingInteger.findSmallestMissingInteger(nArray));
    }
}
