import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileParser {
    public static void main(String[] args) throws IOException {
        String filePath = "path/to/your/largefile.txt";
        List<String[]> parsedData = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split each line by "," after removing the surrounding quotes
                String[] columns = line.replaceAll("^\"|\"$", "").split("\", \"");
                parsedData.add(columns);
            }
        }

        // Process your data here
        System.out.println("Total lines processed: " + parsedData.size());
    }
}