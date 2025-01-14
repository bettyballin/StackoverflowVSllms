import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class HtmlEntityConverter {

    private static final Map<Character, String> htmlCharToEntity = new HashMap<>();

    static {
        // Add character to entity mappings
        htmlCharToEntity.put('<', "&lt;");
        htmlCharToEntity.put('>', "&gt;");
        htmlCharToEntity.put('&', "&amp;");
        htmlCharToEntity.put('"', "&quot;");
        // You can add more characters as needed for your locale
    }

    public static void convertFile(String inputFile, String outputFile) throws Exception {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             FileWriter writer = new FileWriter(outputFile)) {

            int character;
            while ((character = reader.read()) != -1) {
                char c = (char) character;
                if (htmlCharToEntity.containsKey(c)) {
                    writer.write(htmlCharToEntity.get(c));
                } else {
                    writer.write(character);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        convertFile("path/to/your/input.txt", "path/to/your/output.html");
    }
}