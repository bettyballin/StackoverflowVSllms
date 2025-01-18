import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVParser;
import java.io.*;

public class CSVExample {
    public static void main(String[] args) throws IOException {
        Reader in = new FileReader("path/to/file.csv");
        CSVParser parser = CSVFormat.EXCEL.parse(in);
        for (CSVRecord record : parser) {
            String columnOne = record.get(0);
            int value = Integer.parseInt(record.get(1)); // assuming the second field is an integer
            // Your code here
        }
        parser.close();
    }
}