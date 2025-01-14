import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileQueryReader {
    // Example in Java using BufferedReader to read a query from an external file
    public String readQueryFromFile(String filePath) throws IOException {
        StringBuilder query = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                query.append(line).append(System.lineSeparator());
            }
        }
        return query.toString().trim();
    }

    public static void main(String[] args) {
    }
}