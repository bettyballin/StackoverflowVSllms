import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

public class PropertiesReaderWriter {

    public static String getInProperties(String pluginId, String propertiesFile, String propertyKey) {
        Bundle bundle = FrameworkUtil.getBundle(PropertiesReaderWriter.class);
        try (InputStream in = bundle.getEntry("/" + pluginId + "/" + propertiesFile).openStream()) {
            if (in == null) {
                throw new IOException("Property file not found: " + propertiesFile);
            }
            Properties prop = new Properties();
            prop.load(in);
            return prop.getProperty(propertyKey);
        } catch (IOException e) {
            System.err.println("Error reading property from " + propertiesFile + ": " + e.getMessage());
            return null;
        }
    }

    public static void setInProperties(String pluginId, String propertiesFile, String propertyKey, String propertyValue) throws IOException {
        // Writing to a file in a bundle is not recommended. Instead, consider using a different approach,
        // such as storing configuration in an external file or preference store.
        throw new UnsupportedOperationException("Writing directly to properties files within bundles is not supported.");
    }

    public static void main(String[] args) {
    }
}