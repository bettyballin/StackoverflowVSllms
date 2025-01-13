/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Collections;

public class SortingExample {
    public static void main(String[] stringArray) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < 1000; ++i) {
            arrayList.add(i);
        }
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        for (int i = 0; i < 1000; ++i) {
            arrayList2.add((int)(Math.random() * 1000.0));
        }
        arrayList.addAll(arrayList2);
        Collections.sort(arrayList);
        ArrayList<Integer> arrayList3 = new ArrayList<Integer>();
        for (int i = 0; i < 1000; ++i) {
            arrayList3.add(i);
        }
        for (Integer n : arrayList2) {
            int n2 = Collections.binarySearch(arrayList3, n);
            if (n2 < 0) {
                n2 = -n2 - 1;
            }
            arrayList3.add(n2, n);
        }
    }
}
