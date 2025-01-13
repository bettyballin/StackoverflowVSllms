/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;

public class BinarySearchUtil {
    public static int binarySearch(List<Integer> list, int n) {
        int n2 = 0;
        int n3 = list.size() - 1;
        while (n2 <= n3) {
            int n4 = (n2 + n3) / 2;
            int n5 = list.get(n4);
            if (n5 == n) {
                return n4;
            }
            if (n5 < n) {
                n2 = n4 + 1;
                continue;
            }
            n3 = n4 - 1;
        }
        return -1;
    }

    public static void main(String[] stringArray) {
    }
}
