import java.lang.String;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileExporter {
    
    public void exportFileFromJar(String resourcePath, String targetFilePath) throws Exception {
        // Get the InputStream from the resource within the JAR
        try (InputStream in = getClass().getClassLoader().getResourceAsStream(resourcePath)) {
            if (in == null) {
                throw new Exception("Resource not found: " + resourcePath);
            }
            
            // Write the file to the target location
            try (OutputStream out = Files.newOutputStream(Paths.get(targetFilePath), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        FileExporter exporter = new FileExporter();
        // Example usage: the resource path is relative to the root of the JAR
        exporter.exportFileFromJar("com/test/io/test.txt", "/path/to/your/target/file.txt");
    }
}