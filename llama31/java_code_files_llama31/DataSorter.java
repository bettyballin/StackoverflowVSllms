/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataSorter {
    public static void main(String[] stringArray) {
        ArrayList<List<String>> arrayList = new ArrayList<List<String>>();
        arrayList.add(Arrays.asList("John", "Doe"));
        arrayList.add(Arrays.asList("Jane", "Aoe"));
        arrayList.add(Arrays.asList("Bob", "Coe"));
        arrayList.sort((list, list2) -> ((String)list.get(1)).compareTo((String)list2.get(1)));
        for (List list3 : arrayList) {
            System.out.println(list3);
        }
    }
}
