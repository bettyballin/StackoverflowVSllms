import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MyComparator_1_1 implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        // Add elements to the list to be sorted
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        Collections.sort(list, new MyComparator_1());

        // Print the sorted list
        for (String str : list) {
            System.out.println(str);
        }
    }
}