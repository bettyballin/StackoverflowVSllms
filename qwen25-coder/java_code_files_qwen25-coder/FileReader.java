import java.lang.String;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

public class FileReader {
    public static void main(String[] args) {
        String fileName = "map.mp";
        InputStream inputStream = null;

        // Try to load resource from the classpath
        URL url = FileReader.class.getResource(fileName);
        if (url != null) {
            try {
                inputStream = new FileInputStream(new File(url.getFile()));
                System.out.println("File found in classpath: " + fileName);
            } catch (Exception e) {
                System.err.println("Error reading file from classpath: " + e.getMessage());
            }
        } else {
            // If not found, try to load it from the filesystem
            File file = new File(fileName);
            if (file.exists()) {
                try {
                    inputStream = new FileInputStream(file);
                    System.out.println("File found in filesystem: " + fileName);
                } catch (Exception e) {
                    System.err.println("Error reading file from filesystem: " + e.getMessage());
                }
            } else {
                System.err.println("File not found: " + fileName);
            }
        }

        // Close the inputStream if it was opened
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e) {
                System.err.println("Error closing InputStream: " + e.getMessage());
            }
        }
    }
}