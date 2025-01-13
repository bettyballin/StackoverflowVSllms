import java.lang.String;

public class ProxyConfig {
    String proxyHost = System.getProperty("http.proxyHost");
    String proxyPort = System.getProperty("http.proxyPort");

    public static void main(String[] args) {
        // Create an instance of ProxyConfig to avoid the warning
        // "non-static variable cannot be referenced from a static context"
        ProxyConfig config = new ProxyConfig();
        // You can add code here to use the config object
    }
}