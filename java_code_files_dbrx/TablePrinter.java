import java.util.List;
import java.util.Arrays;

public class TablePrinter {
    public static void main(String[] args) {
        // Example column labels, max widths, and dummy data
        List<String> headers = Arrays.asList("Field", "Type", "Null", "Key", "Default", "Extra");
        List<Integer> maxWidths = Arrays.asList(8, 15, 6, 4, 7, 7);
        List<String[]> tableData = Arrays.asList(
                new String[]{ "name", "varchar(100)", "YES", "", "NULL", "" },
                new String[]{ "release", "year(4)", "YES", "", "NULL", "" }
        );

        // Custom format for table rows, replace "%s" with real data later using `String.format`
        int numCols = headers.size();
        String rowFormat = "+";
        for (Integer width : maxWidths) {
            rowFormat += String.format("%%-%ds-+", width); // Use String.format to produce format string for rows
        }
        rowFormat += "\n";

        // Build the separator line
        String separator = "+";
        for (Integer width : maxWidths) {
            separator += "-" + "-".repeat(width) + "-+";
        }
        separator += "\n";

        // Print the top separator
        System.out.print(separator);

        // Print headers using `String.format`
        System.out.printf(rowFormat, headers.toArray());

        // Print the separator between headers and data
        System.out.print(separator);

        // Print data rows using `String.format`
        for (String[] row : tableData) {
            System.out.printf(rowFormat, (Object[]) row); // Replace placeholders in format string with real data/header values
        }

        // Print the bottom separator
        System.out.print(separator);
    }
}