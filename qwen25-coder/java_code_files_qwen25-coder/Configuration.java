import java.io.InputStream;
import java.util.Properties;
import javax.servlet.ServletContext;

public class Configuration {
    private static final String PROPERTIES_FILE = "/WEB-INF/config/database.properties";
    private Properties properties;
    private ServletContext context;

    public Configuration(ServletContext context) throws Exception {
        this.context = context;
        InputStream inputStream = getInputStream();
        properties = new Properties();
        properties.load(inputStream);
    }

    private InputStream getInputStream() throws Exception {
        return context.getResourceAsStream(PROPERTIES_FILE);
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}