import java.util.ArrayList;
import java.util.List;

public class Main_745 {
    public static void main(String[] args) {
        List<List<String>> table = new ArrayList<>();

        // ... populate the table list ...

        // Adding some sample data to the table for demonstration
        List<String> row1 = new ArrayList<>();
        row1.add("Row1Col1");
        row1.add("Row1Col2");
        table.add(row1);

        List<String> row2 = new ArrayList<>();
        row2.add("Row2Col1");
        row2.add("Row2Col2");
        table.add(row2);

        Object[][] finalData = table.stream()
                .map(row -> row.toArray())
                .toArray(Object[][]::new);

        // Print the finalData for demonstration
        for (Object[] row : finalData) {
            for (Object cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}