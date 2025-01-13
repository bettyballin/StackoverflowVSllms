import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;

public class DescendingDoubleComparator {
    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        list.add(10.5);
        list.add(5.2);
        list.add(15.1);

        Collections.sort(list, new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return o2.compareTo(o1);
            }
        });

        System.out.println(list);
    }
}