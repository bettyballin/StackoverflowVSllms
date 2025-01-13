import java.lang.String;
import java.util.Properties;
import java.io.FileReader;
import java.io.IOException;

class PropertiesReader {
    public static String getInProperties(String namespace, String filename, String propertyId) {
        Properties properties = new Properties();
        try (FileReader reader = new FileReader(filename)) {
            properties.load(reader);
        } catch (IOException e) {
            System.err.println("Error reading properties file: " + e.getMessage());
            return null;
        }
        return properties.getProperty(namespace + "." + propertyId);
    }
}

public class ConfigurationLoader {
    String value = PropertiesReader.getInProperties("org.anyname.myplugins.mypluginthatrocks", "myawsomeproperties.properties", "myPropertyId");

    public static void main(String[] args) {
    }
}