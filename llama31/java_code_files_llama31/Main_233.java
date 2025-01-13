/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main_233 {
    public static void main(String[] stringArray) {
        List list42;
        List<Integer> list2 = Arrays.asList(5, 2, 8, 3, 1, 6, 4);
        List list3 = list2.stream().map(n -> new KeyValue((Integer)n, (Integer)n)).collect(Collectors.toList());
        int n2 = 2;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < n2; ++i) {
            arrayList.add(new ArrayList());
        }
        for (List list42 : list3) {
            int n3 = ((KeyValue)((Object)list42)).getKey() % n2;
            ((List)arrayList.get(n3)).add(list42);
        }
        ArrayList arrayList2 = new ArrayList();
        for (List list5 : arrayList) {
            Collections.sort(list5, Comparator.comparing(KeyValue::getKey));
            arrayList2.addAll(list5);
        }
        list42 = arrayList2.stream().map(KeyValue::getValue).collect(Collectors.toList());
        System.out.println(list42);
    }
}
