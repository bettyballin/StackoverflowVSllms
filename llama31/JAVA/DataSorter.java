import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class DataSorter {
    public static void main(String[] args) {
        List<List<String>> records = new ArrayList<>();
        // add some example data to records
        records.add(Arrays.asList("John", "Doe"));
        records.add(Arrays.asList("Jane", "Aoe"));
        records.add(Arrays.asList("Bob", "Coe"));

        records.sort((o1, o2) -> o1.get(1).compareTo(o2.get(1)));

        // print sorted records
        for (List<String> record : records) {
            System.out.println(record);
        }
    }
}