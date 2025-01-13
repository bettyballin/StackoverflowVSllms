/*
 * Decompiled with CFR 0.152.
 */
public class SearchUtil {
    public static int linearSearch(int[] nArray, int n) {
        for (int i = 0; i < nArray.length; ++i) {
            if (nArray[i] != n) continue;
            return i;
        }
        return -1;
    }

    public static void main(String[] stringArray) {
    }
}
