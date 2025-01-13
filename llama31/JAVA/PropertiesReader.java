import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;

public class PropertiesReader {
    public String getInProperties(String pluginId, String fileName, String propertyId) {
        try {
            File file = FileLocator.resolve(new Path(pluginId, fileName)).toFile();
            Properties props = new Properties();
            props.load(new FileInputStream(file));
            return props.getProperty(propertyId);
        } catch (IOException e) {
            System.err.println("Error reading properties: " + e.getMessage());
            return null;
        }
    }

    public void setInProperties(String pluginId, String fileName, String propertyId, String propertyValue) {
        try {
            File file = FileLocator.resolve(new Path(pluginId, fileName)).toFile();
            Properties props = new Properties();
            props.load(new FileInputStream(file));
            props.setProperty(propertyId, propertyValue);
            props.store(new FileOutputStream(file), null);
        } catch (IOException e) {
            System.err.println("Error writing properties: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Example usage
        PropertiesReader reader = new PropertiesReader();
        String pluginId = "your.plugin.id";
        String fileName = "config.properties";
        String propertyId = "some.property";
        String propertyValue = "newValue";

        String currentValue = reader.getInProperties(pluginId, fileName, propertyId);
        System.out.println("Current value of " + propertyId + ": " + currentValue);

        reader.setInProperties(pluginId, fileName, propertyId, propertyValue);
        System.out.println("Updated value of " + propertyId + ": " + propertyValue);
    }
}