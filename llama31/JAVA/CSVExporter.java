import java.lang.String;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CSVExporter {
    public static void main(String[] args) {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter("output.csv"));
            writer.writeNext(new String[] {"Field 1", "Field 2 with \r encoded"});
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}