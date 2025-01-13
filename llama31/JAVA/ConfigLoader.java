import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

// Assuming you have a Config class defined somewhere
class Config {
    // Your configuration properties here
}

public class ConfigLoader {
    // Load configuration from a JSON file
    private static ObjectMapper mapper = new ObjectMapper();
    private static Config config;

    public static void main(String[] args) {
        try {
            config = mapper.readValue(new File("config.json"), Config.class);
        } catch (IOException e) {
            System.out.println("Failed to load configuration: " + e.getMessage());
        }
    }
}