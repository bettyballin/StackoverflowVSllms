import java.lang.String;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVParser {
    public static void main(String[] args) throws IOException {
        String csvFile = "example.csv";
        BufferedReader br = new BufferedReader(new FileReader(csvFile));
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            for (String value : values) {
                // Handle quoted values
                if (value.startsWith("\"") && value.endsWith("\"")) {
                    value = value.substring(1, value.length() - 1);
                }
                // Handle escaped commas
                value = value.replace("\\,", ",");
                System.out.println(value);
            }
        }
    }
}