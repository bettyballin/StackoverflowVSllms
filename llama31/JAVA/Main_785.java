import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main_785 {
    public static void main(String[] args) throws IOException {
        // Read the CSV file
        CSVReader reader = new CSVReader(new FileReader("input.csv"));
        List<String[]> rows = reader.readAll();

        // Perform some transformations
        for (String[] row : rows) {
            // Do something with the row...
            row[1] = row[1].toUpperCase();
        }

        // Write the transformed data to a new CSV file
        CSVWriter writer = new CSVWriter(new FileWriter("output.csv"));
        writer.writeAll(rows);
        writer.close(); // Changed from flush() to close() for better resource handling
    }
}