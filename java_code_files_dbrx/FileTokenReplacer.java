import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FileTokenReplacer {

    private static final String PROPS_FILE = "path/to/your/.properties"; // replace with your properties file path
    private Map<String, String> propsMap;
    private Pattern pattern;

    public void replaceTokens(Path dir) throws IOException {
        loadPropertiesFile();
        pattern = compilePattern();
        Files.walk(dir).forEach(this::processFiles);
    }

    private void processFiles(Path path) {
        if (Files.isRegularFile(path)) {
            try {
                List<String> updatedLines = replaceTokensInFile(path); // Replace tokens in each line of the file
                Files.write(path, updatedLines, StandardCharsets.UTF_8); // Save the changes to files
            } catch (IOException e) {
                throw new RuntimeException("Failed to process: " + path, e);
            }
        }
    }

    private List<String> replaceTokensInFile(Path path) throws IOException {
        return Files.readAllLines(path).stream()
                .map(line -> pattern.matcher(line)
                        .replaceAll(matchResult -> propsMap.getOrDefault(matchResult.group(), ""))) // Replace string tokens or empty if not found in properties file
                .collect(Collectors.toList());
    }

    private void loadPropertiesFile() { // Load property values in map for quick retrieval later on
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream(PROPS_FILE)) {
            props.load(fis);
            propsMap = props.stringPropertyNames().stream() // Convert to map for quicker retrieval using get method
                    .collect(Collectors.toMap(
                            key -> "${" + key + "}", // Key in the format of your string token example: "${some.property}"
                            key -> props.getProperty(key)));
        } catch (IOException ex) {
            throw new RuntimeException("Failed to load properties file.", ex);
        }
    }

    private Pattern compilePattern() {
        String patternString = propsMap.keySet().stream()
                .map(Pattern::quote)
                .collect(Collectors.joining("|")); // Compile the regular expression for all property keys to search in files
        return Pattern.compile(patternString);
    }

    public static void main(String[] args) {
    }
}