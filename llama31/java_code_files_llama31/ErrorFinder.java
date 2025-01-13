/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;
import java.util.Map;

public class ErrorFinder {
    public static int[] findError(int[] nArray, int[] nArray2) {
        int n;
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (n = 0; n < nArray.length; ++n) {
            if (!hashMap.containsKey(nArray[n])) {
                hashMap.put(nArray[n], 1);
                continue;
            }
            hashMap.put(nArray[n], (Integer)hashMap.get(nArray[n]) + 1);
        }
        for (n = 0; n < nArray2.length; ++n) {
            if (!hashMap.containsKey(nArray2[n])) continue;
            hashMap.put(nArray2[n], (Integer)hashMap.get(nArray2[n]) - 1);
            if ((Integer)hashMap.get(nArray2[n]) != 0) continue;
            hashMap.remove(nArray2[n]);
        }
        int[] nArray3 = new int[hashMap.size()];
        int n2 = 0;
        for (Map.Entry entry : hashMap.entrySet()) {
            nArray3[n2++] = (Integer)entry.getKey();
        }
        return nArray3;
    }

    public static void main(String[] stringArray) {
        int[] nArray;
        int[] nArray2 = new int[]{1, 2, 3, 4, 5};
        int[] nArray3 = new int[]{1, 2, 3};
        for (int n : nArray = ErrorFinder.findError(nArray2, nArray3)) {
            System.out.println(n);
        }
    }
}
