import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyPersister {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("lastOpenedFile", "/path/to/file");
        try (FileOutputStream fos = new FileOutputStream("app.properties")) {
            props.store(fos, null);
        } catch (IOException e) {
            System.err.println("Error storing properties: " + e.getMessage());
        }
    }
}