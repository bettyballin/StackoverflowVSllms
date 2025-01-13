import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

public class ExternalResourceBundle extends ResourceBundle {
    private Properties properties;

    public ExternalResourceBundle(String bundleName, String externalPath) {
        properties = new Properties();
        try {
            File externalFile = new File(externalPath, bundleName + ".properties");
            properties.load(new FileInputStream(externalFile));
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Override
    protected Object handleGetObject(String key) {
        return properties.getProperty(key);
    }

    @Override
    public Enumeration<String> getKeys() {
        return (Enumeration<String>) properties.propertyNames();
    }

    public static void main(String[] args) {
        // Create an instance of ExternalResourceBundle to test the class
        ExternalResourceBundle bundle = new ExternalResourceBundle("mybundle", "/path/to/properties");
        System.out.println(bundle.getString("mykey"));
    }
}