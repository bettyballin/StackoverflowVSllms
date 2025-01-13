import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TSVFileValidator {

    public static boolean validateTSVFileFormat(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 0;
            while ((line = br.readLine()) != null && lineNumber < 5) { // read first 5 lines
                String[] values = line.split("\t");
                if (values.length < 2) { // adjust the minimum number of columns
                    return false;
                }
                lineNumber++;
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String filePath = "path/to/your/file.tsv"; // Replace with your actual file path
        boolean isValid = validateTSVFileFormat(filePath);
        System.out.println("Is the TSV file format valid? " + isValid);
    }
}