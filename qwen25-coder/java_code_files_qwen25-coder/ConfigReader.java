import java.lang.String;
import java.util.Properties;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ConfigReader {
    public static void main(String[] args) {
        // Example of reading a property file
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("config.properties");
            prop.load(input);
            String productId1 = prop.getProperty("homepage.product1.id");
            // Fetch product details using the ID and set it in request scope
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}