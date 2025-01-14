import java.util.HashMap;

public class ConfigManager {
    private String headersPath;
    public HashMap<String, Object> configMapping = new HashMap<>();

    public ConfigManager() {
        // Store the reference to headersPath in the map
        configMapping.put("HEADERS_PATH", this.headersPath);
    }

    public void setHeadersPath(String path) {
        this.headersPath = path;
        // Update the reference in the map
        configMapping.put("HEADERS_PATH", this.headersPath);
    }

    public String getHeadersPath() {
        return (String) configMapping.get("HEADERS_PATH");
    }

    public static void main(String[] args) {
        ConfigManager manager = new ConfigManager();
        manager.setHeadersPath("/new/path/to/headers");
        System.out.println(manager.getHeadersPath()); // Outputs: /new/path/to/headers
    }
}