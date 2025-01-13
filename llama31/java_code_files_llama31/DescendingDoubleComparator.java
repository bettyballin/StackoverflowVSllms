/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DescendingDoubleComparator {
    public static void main(String[] stringArray) {
        ArrayList<Double> arrayList = new ArrayList<Double>();
        arrayList.add(10.5);
        arrayList.add(5.2);
        arrayList.add(15.1);
        Collections.sort(arrayList, new Comparator<Double>(){

            @Override
            public int compare(Double d, Double d2) {
                return d2.compareTo(d);
            }
        });
        System.out.println(arrayList);
    }
}
