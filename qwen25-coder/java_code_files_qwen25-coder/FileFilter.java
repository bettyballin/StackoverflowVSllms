import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class FileFilter {

    public static void filterFilesInDirectory(String directoryPath, String propertiesFilePath) throws IOException {
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream(propertiesFilePath)) {
            // Load the properties file
            properties.load(input);
        }

        Files.walkFileTree(Paths.get(directoryPath), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                String content = new String(Files.readAllBytes(file));
                for (Entry<Object, Object> entry : properties.entrySet()) {
                    String key = "${" + entry.getKey() + "}";
                    String value = (String) entry.getValue();
                    content = content.replace(key, value);
                }
                Files.write(file, content.getBytes(), StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    public static void main(String[] args) {
        try {
            filterFilesInDirectory("/path/to/your/directory", "/path/to/your/config.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}