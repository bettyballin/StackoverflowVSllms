import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main_379 {
    public static void main(String[] args) {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream("path/to/config.properties"));
            String soapEndpoint = props.getProperty("soap.endpoint");
            System.out.println(soapEndpoint);
        } catch (IOException e) {
            System.err.println("Error loading properties file: " + e.getMessage());
        }
    }
}