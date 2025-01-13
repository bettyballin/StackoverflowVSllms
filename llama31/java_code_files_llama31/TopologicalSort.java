/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TopologicalSort {
    public static List<String> sort(Map<String, List<String>> map) {
        ArrayList<String> arrayList = new ArrayList<String>();
        HashSet<String> hashSet = new HashSet<String>();
        for (String string : map.keySet()) {
            if (hashSet.contains(string)) continue;
            TopologicalSort.visit(string, map, hashSet, arrayList);
        }
        return arrayList;
    }

    private static void visit(String string, Map<String, List<String>> map, Set<String> set, List<String> list) {
        set.add(string);
        for (String string2 : map.get(string)) {
            if (set.contains(string2)) continue;
            TopologicalSort.visit(string2, map, set, list);
        }
        list.add(string);
    }

    public static void main(String[] stringArray) {
        HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();
        hashMap.put("A", Arrays.asList("B", "D"));
        hashMap.put("D", Arrays.asList("B", "C"));
        hashMap.put("B", Arrays.asList("C", "E"));
        hashMap.put("C", Collections.emptyList());
        hashMap.put("E", Collections.emptyList());
        List<String> list = TopologicalSort.sort(hashMap);
        System.out.println(list);
    }
}
