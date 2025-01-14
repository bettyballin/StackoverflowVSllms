import java.lang.String;
import java.io.*;
import java.nio.file.*;

public class JarFileExtractor {

    public static void main(String[] args) {
        String sourceFilePath = "/com/test/io/test.txt"; // Note the leading slash
        Path destinationFilePath = Paths.get("path/to/destination/test.txt");

        try (InputStream inputStream = JarFileExtractor.class.getResourceAsStream(sourceFilePath);
             OutputStream outputStream = Files.newOutputStream(destinationFilePath)) {

            if (inputStream == null) {
                throw new FileNotFoundException("Resource not found in JAR: " + sourceFilePath);
            }

            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}