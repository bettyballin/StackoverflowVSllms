import java.lang.String;

public class ProxyConfigurator_2_2 {
    public static void main(String[] args) {
        System.setProperty("http.proxyHost", "your_proxy_host");
        System.setProperty("http.proxyPort", "your_proxy_port");
    }
}