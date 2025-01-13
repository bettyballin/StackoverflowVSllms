import java.lang.String;

// Define the ExternalResourceBundle class
class ExternalResourceBundle {
    private String bundleName;
    private String path;

    public ExternalResourceBundle(String bundleName, String path) {
        this.bundleName = bundleName;
        this.path = path;
    }

    public String getString(String key) {
        // You might want to implement actual logic to retrieve string from bundle
        return "Some value"; // placeholder implementation
    }
}

public class ResourceAccessor {
    ExternalResourceBundle bundle = new ExternalResourceBundle("application", "../properties");
    String pluginName = bundle.getString("%plugin.name");

    public static void main(String[] args) {
        ResourceAccessor accessor = new ResourceAccessor();
        System.out.println(accessor.pluginName);
    }
}