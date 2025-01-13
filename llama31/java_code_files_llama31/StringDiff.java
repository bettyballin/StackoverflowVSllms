/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

public class StringDiff {
    public static List<int[]> diff(String string, String string2) {
        int n;
        int n2;
        int[][] nArray = new int[string.length() + 1][string2.length() + 1];
        for (n2 = 0; n2 <= string.length(); ++n2) {
            nArray[n2][0] = n2;
        }
        for (n2 = 0; n2 <= string2.length(); ++n2) {
            nArray[0][n2] = n2;
        }
        for (n2 = 1; n2 <= string.length(); ++n2) {
            for (n = 1; n <= string2.length(); ++n) {
                nArray[n2][n] = string.charAt(n2 - 1) == string2.charAt(n - 1) ? nArray[n2 - 1][n - 1] : Math.min(Math.min(nArray[n2 - 1][n - 1] + 1, nArray[n2 - 1][n] + 1), nArray[n2][n - 1] + 1);
            }
        }
        ArrayList<int[]> arrayList = new ArrayList<int[]>();
        n = string.length();
        int n3 = string2.length();
        while (n > 0 || n3 > 0) {
            if (n > 0 && n3 > 0 && string.charAt(n - 1) == string2.charAt(n3 - 1)) {
                --n;
                --n3;
                continue;
            }
            if (n3 > 0 && (n == 0 || nArray[n][n3] == nArray[n][n3 - 1] + 1)) {
                arrayList.add(new int[]{n, n3 - 1});
                --n3;
                continue;
            }
            if (n > 0 && (n3 == 0 || nArray[n][n3] == nArray[n - 1][n3] + 1)) {
                arrayList.add(new int[]{n - 1, n3});
                --n;
                continue;
            }
            arrayList.add(new int[]{n - 1, n3 - 1});
            --n;
            --n3;
        }
        return arrayList;
    }

    public static void main(String[] stringArray) {
        List<int[]> list = StringDiff.diff("abcd", "aacd");
        System.out.println(list);
        list = StringDiff.diff("maniac", "brainiac");
        System.out.println(list);
    }
}
