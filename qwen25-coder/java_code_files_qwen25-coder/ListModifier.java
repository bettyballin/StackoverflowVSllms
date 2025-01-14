import java.util.ArrayList;
import java.util.List;

public class ListModifier {
    public static void main(String[] args) {
        List<String> rows = new ArrayList<>();
        // Assume rows are populated with data

        while (!rows.isEmpty()) {
            String currentRow = rows.remove(0); // Process and remove the first element
            processRow(currentRow, rows); // Process the row and possibly modify the list
        }
    }

    private static void processRow(String row, List<String> rows) {
        // Your processing logic here
        System.out.println("Processing: " + row);

        // Example condition to remove other elements
        if (row.contains("delete")) {
            rows.removeIf(r -> r.contains("toDelete")); // Remove matching elements
        }
    }
}