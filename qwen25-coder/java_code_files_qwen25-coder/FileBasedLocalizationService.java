import java.util.Map;
import java.util.HashMap;
import java.util.Properties;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;

// Import the OSGi Component annotation
import org.osgi.service.component.annotations.Component;

// Example of a custom Localization Service interface
public interface ExternalLocalizationService {
    String getLocalizedText(String key);
}

// Example implementation that reads from an external location
@Component(service = ExternalLocalizationService.class)
public class FileBasedLocalizationService implements ExternalLocalizationService {
    private Map<String, String> localizedStrings;

    public void activate() throws IOException {
        localizedStrings = new HashMap<>();
        Properties properties = new Properties();
        try (InputStream inputStream = new FileInputStream("/path/to/external/application.properties")) {
            properties.load(inputStream);
        }
        properties.forEach((k, v) -> this.localizedStrings.put(String.valueOf(k), String.valueOf(v)));
    }

    @Override
    public String getLocalizedText(String key) {
        return localizedStrings.get(key);
    }

    public static void main(String[] args) {
    }
}