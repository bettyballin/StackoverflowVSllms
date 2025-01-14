import java.lang.String;
import java.io.*;
import java.util.regex.*;

public class WordExtractor {
    public static void main(String[] args) {
        String filePath = "path/to/17921-8.txt"; // Update with your file path
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            Pattern wordPattern = Pattern.compile("\\b\\w+(?:'\\w+)?\\b");
            Matcher matcher;

            while ((line = reader.readLine()) != null) {
                matcher = wordPattern.matcher(line);
                while (matcher.find()) {
                    System.out.println(matcher.group());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}