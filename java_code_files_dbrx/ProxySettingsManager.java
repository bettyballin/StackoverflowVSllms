import java.lang.String;
public class ProxySettingsManager {
    static {
        System.setProperty("http.proxyHost", "proxy_host");
        System.setProperty("http.proxyPort", "proxy_port");
    }
    public static void main(String[] args) {
    }
}