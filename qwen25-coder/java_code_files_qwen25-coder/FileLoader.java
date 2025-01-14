import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class FileLoader {
    private static final String DIRECTORY_PATH = "/path/to/your/files";

    public Map<String, String> loadFiles() throws IOException {
        Map<String, String> fileContents = new HashMap<>();
        Files.list(Paths.get(DIRECTORY_PATH))
                .filter(path -> path.toString().endsWith(".txt")) // Adjust extension as necessary
                .forEach(filePath -> {
                    try (BufferedReader reader = Files.newBufferedReader(filePath)) {
                        StringBuilder contentBuilder = new StringBuilder();
                        String currentLine;
                        while ((currentLine = reader.readLine()) != null) {
                            contentBuilder.append(currentLine).append(System.lineSeparator());
                        }
                        fileContents.put(filePath.getFileName().toString(), contentBuilder.toString().trim());
                    } catch (IOException e) {
                        System.err.println("Error reading " + filePath + ": " + e.getMessage());
                    }
                });
        return fileContents;
    }

    public static void main(String[] args) {
        FileLoader loader = new FileLoader();
        try {
            Map<String, String> filesData = loader.loadFiles();
            // Now you can manipulate `filesData`
            for (Map.Entry<String, String> entry : filesData.entrySet()) {
                System.out.println("File: " + entry.getKey());
                System.out.println("Content: " + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}