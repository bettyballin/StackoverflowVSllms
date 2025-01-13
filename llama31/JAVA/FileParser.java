import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileParser {
    public static void main(String[] args) throws IOException {
        String filePath = "path/to/your/file.txt";
        List<String[]> parsedData = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                // Trim each field to remove quotes and whitespace
                for (int i = 0; i < fields.length; i++) {
                    fields[i] = fields[i].trim().replaceAll("\"", "");
                }
                parsedData.add(fields);
            }
        }

        // Process the parsed data
        for (String[] fields : parsedData) {
            // Do something with the fields
            System.out.println(java.util.Arrays.toString(fields));
        }
    }
}