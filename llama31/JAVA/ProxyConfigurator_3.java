import java.lang.String;

public class ProxyConfigurator_3_3 {
    public static void main(String[] args) {
        System.setProperty("http.proxyUser", "your_proxy_username");
        System.setProperty("http.proxyPassword", "your_proxy_password");
    }
}