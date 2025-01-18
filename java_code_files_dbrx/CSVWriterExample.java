import java.io.*;
import com.opencsv.CSVWriter;

public class CSVWriterExample {
    public static void main(String[] args) throws Exception {
        FileWriter writer = new FileWriter("filename.csv"); // specify encoding here if needed, e.g., "UTF-8" or "windows-1252"
        try (CSVWriter csvWriter = new CSVWriter(writer)) {
            String[] data = {"field 1", "field 2", "field with comma, value"}; // sample row of your actual data fields from the DB query results
            csvWriter.writeNext(data);
        }
    }
}