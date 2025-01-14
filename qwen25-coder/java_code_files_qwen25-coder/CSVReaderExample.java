import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class CSVReaderExample {
    public static void main(String[] args) throws IOException {
        try (Reader reader = new FileReader("yourfile.csv")) {
            CSVParser parser = CSVFormat.DEFAULT
                .withFirstRecordAsHeader()
                .withIgnoreHeaderCase()
                .withTrim()
                .parse(reader);

            for (CSVRecord csvRecord : parser) {
                System.out.println(csvRecord.get("YourColumnName"));
            }
        }
    }
}