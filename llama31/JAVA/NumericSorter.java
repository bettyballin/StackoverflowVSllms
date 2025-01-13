import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

public class NumericSorter {
    public static void main(String[] args) {
        NumericSorter sorter = new NumericSorter();
        // You need to define 'themap' somewhere in your code, 
        // I assume it's a Map, so I added a simple example.
        Map<String, Double> themap = Map.of("a", 1.0, "b", 2.0, "c", 3.0);
        sorter.sortAndPrint(themap);
    }

    public void sortAndPrint(Map<String, Double> themap) {
        List<Double> list = themap.values().stream()
                .sorted((o1, o2) -> o2.compareTo(o1))
                .collect(Collectors.toList());
        System.out.println(list);
    }
}