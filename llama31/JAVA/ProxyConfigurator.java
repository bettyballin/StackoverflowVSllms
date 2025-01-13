import java.lang.String;

public class ProxyConfigurator {
    static {
        System.setProperty("http.proxyHost", "myproxy.com");
        System.setProperty("http.proxyPort", "9191");
    }

    public static void main(String[] args) {
    }
}