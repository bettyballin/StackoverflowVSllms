import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortExample {
    private List<String> subList;
    private List<List<String>> records = new ArrayList<>();

    public void populateAndSort() {
        // Populate the records list with example data
        subList = new ArrayList<>();
        subList.add("10");
        subList.add("20");
        subList.add("30");
        records.add(new ArrayList<>(subList)); // Adding a copy of subList

        subList.clear();
        subList.add("10");
        subList.add("05");
        subList.add("30");
        records.add(new ArrayList<>(subList)); // Adding a copy of subList

        subList.clear();
        subList.add("10");
        subList.add("35");
        subList.add("30");
        records.add(new ArrayList<>(subList)); // Adding a copy of subList

        // Sort the records list by the second element ("b") in each sublist
        Collections.sort(records, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                return o1.get(1).compareTo(o2.get(1)); // Compare based on the second element
            }
        });

        // Output sorted records
        for (List<String> record : records) {
            System.out.println(record);
        }
    }

    public static void main(String[] args) {
        SortExample example = new SortExample();
        example.populateAndSort();
    }
}