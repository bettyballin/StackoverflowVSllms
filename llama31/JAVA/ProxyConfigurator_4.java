import java.lang.System;

public class ProxyConfigurator_4_4 {
    public static void main(String[] args) {
        System.setProperty("https.proxyHost", "your_proxy_host");
        System.setProperty("https.proxyPort", "your_proxy_port");
    }
}