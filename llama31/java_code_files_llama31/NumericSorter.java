/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NumericSorter {
    public static void main(String[] stringArray) {
        NumericSorter numericSorter = new NumericSorter();
        Map<String, Double> map = Map.of("a", 1.0, "b", 2.0, "c", 3.0);
        numericSorter.sortAndPrint(map);
    }

    public void sortAndPrint(Map<String, Double> map) {
        List list = map.values().stream().sorted((d, d2) -> d2.compareTo((Double)d)).collect(Collectors.toList());
        System.out.println(list);
    }
}
