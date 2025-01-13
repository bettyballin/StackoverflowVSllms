/*
 * Decompiled with CFR 0.152.
 */
class UniqueExtractor {
    UniqueExtractor() {
    }

    public static int[] extractUniques(int[] nArray, int n) {
        int[] nArray2 = new int[n];
        int n2 = 0;
        block0: for (int n3 : nArray) {
            for (int i = 0; i < n2; ++i) {
                if (nArray2[i] == n3) continue block0;
            }
            if (n2 >= n) break;
            nArray2[n2++] = n3;
        }
        if (n2 < n) {
            int[] nArray3 = new int[n2];
            System.arraycopy(nArray2, 0, nArray3, 0, n2);
            return nArray3;
        }
        return nArray2;
    }
}
