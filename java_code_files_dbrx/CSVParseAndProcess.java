import java.io.*;
import org.apache.commons.csv.*;

public class CSVParseAndProcess {

    public static void main(String[] args) throws IOException {
        Reader in = new FileReader("input.csv");
        Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
        for (CSVRecord record : records) {
            String lastName = record.get("Last Name");
            //do operations on the data here
        }
    }
}