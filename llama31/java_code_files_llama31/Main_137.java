/*
 * Decompiled with CFR 0.152.
 */
import java.util.Arrays;
import java.util.List;

public class Main_137 {
    public static void main(String[] stringArray) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int n = Main_137.binarySearch(list, 5);
        System.out.println(n);
    }

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
}
