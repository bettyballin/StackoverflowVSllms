import org.displaytag.properties.TableProperties;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DisplayTagConfig {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("src/comp/bre/sub/config/displaytag.properties")) {
            properties.load(fileInputStream);
            TableProperties tableProperties = TableProperties.getInstance(properties);
            // Proceed with your application
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}