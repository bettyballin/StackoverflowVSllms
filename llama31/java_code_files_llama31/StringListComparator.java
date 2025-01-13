/*
 * Decompiled with CFR 0.152.
 */
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringListComparator {
    public static void main(String[] stringArray) {
        List<List<String>> list = List.of(List.of("a", "b"), List.of("c", "d"));
        Collections.sort(list, new Comparator<List<String>>(){

            @Override
            public int compare(List<String> list, List<String> list2) {
                return list.get(1).compareTo(list2.get(1));
            }
        });
    }
}
