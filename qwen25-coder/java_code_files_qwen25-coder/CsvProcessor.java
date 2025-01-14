import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class CsvProcessor {
    public static void main(String[] args) throws Exception {
        // Reading the CSV file
        try (CSVReader reader = new CSVReader(new FileReader("input.csv"))) {
            String[] lineInArray;
            try (CSVWriter writer = new CSVWriter(new FileWriter("output.csv"))) {
                while ((lineInArray = reader.readNext()) != null) {
                    // Transforming data - example: appending "Modified" to each element
                    for (int i = 0; i < lineInArray.length; i++) {
                        lineInArray[i] += " Modified";
                    }
                    writer.writeNext(lineInArray);
                }
            }
        }
    }
}