import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class QueryCSV {
    public static void main(String[] args) throws IOException {
        String csvFile = "path/to/your/file.csv";
        String query = "SELECT * FROM csv WHERE column1 = 'value1'";

        try (CSVReader reader = new CSVReaderBuilder(new FileReader(csvFile))
                .withSkipLines(1) // skip header row
                .build()) {
            String[] headers = reader.readNext();
            int columnIndex = findColumnIndex(headers, "column1");

            for (String[] row : reader) {
                if (row[columnIndex].equals("value1")) {
                    System.out.println(String.join(", ", row));
                }
            }
        }
    }

    private static int findColumnIndex(String[] headers, String columnName) {
        int index = -1;
        for (int i = 0; i < headers.length; i++) {
            if (headers[i].equals(columnName)) {
                index = i;
                break;
            }
        }
        return index;
    }
}