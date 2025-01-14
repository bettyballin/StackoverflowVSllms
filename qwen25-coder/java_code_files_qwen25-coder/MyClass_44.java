import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Arrays;

// Assuming DATAROW is a class with a method getDataColumn() returning List<String>
public class MyClass {

    static class DATAROW {
        private List<String> data;

        public DATAROW(List<String> data) {
            this.data = data;
        }

        public List<String> getDataColumn() {
            return data;
        }

        public String[] toArray(String[] a) {
            return data.toArray(a);
        }
    }

    public static void main(String[] args) {
        List<DATAROW> table = new ArrayList<>();

        // Sample data
        table.add(new DATAROW(Arrays.asList("a", "b", "c")));
        table.add(new DATAROW(Arrays.asList("d", "e", "f")));

        String[][] finalData = table.stream()
            .map(row -> row.toArray(new String[0])) // Convert each List<String> to String[]
            .toArray(String[][]::new); // Collect all arrays into String[][]

        // For demonstration, print finalData
        for (String[] arr : finalData) {
            System.out.println(Arrays.toString(arr));
        }
    }
}