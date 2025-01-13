import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

public class NumericSorter_1_1 {
    public static void main(String[] args) {
        NumericSorter_1 sorter = new NumericSorter_1();
        Map<String, Double> themap = Map.of("a", 2.0, "b", 1.0, "c", 3.0);
        List<Double> list = themap.values().stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(list);
    }
}