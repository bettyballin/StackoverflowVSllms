// This is not Java code, it appears to be a configuration file or a properties file.
// However, I will provide a Java equivalent of the given configuration.

// Define a class to hold the configuration
public class RestFixtureConfig {
    // Define the properties
    private String url;
    private int port;
    private boolean encode;

    // Constructor to initialize the properties
    public RestFixtureConfig(String url, int port, boolean encode) {
        this.url = url;
        this.port = port;
        this.encode = encode;
    }

    // Getters for the properties
    public String getUrl() {
        return url;
    }

    public int getPort() {
        return port;
    }

    public boolean isEncode() {
        return encode;
    }

    public static void main(String[] args) {
        // Create an instance of the config class
        RestFixtureConfig config = new RestFixtureConfig("http://your-tomcat-url.com", 8080, true);
        
        // Print the config values
        System.out.println("URL: " + config.getUrl());
        System.out.println("Port: " + config.getPort());
        System.out.println("Encode: " + config.isEncode());
    }
}