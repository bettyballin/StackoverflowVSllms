import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringListComparator {
    public static void main(String[] args) {
        List<List<String>> records = List.of(
            List.of("a", "b"),
            List.of("c", "d")
        );
        
        Collections.sort(records, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                return o1.get(1).compareTo(o2.get(1));
            }
        });
        
        // You can add code here to print or use the sorted records
    }
}