import java.net.InetSocketAddress;
import java.net.URL;
import java.net.Proxy;
import java.net.URLConnection;

public class HttpProxyConfigurator {
    static {
        System.getProperties().put("http.proxyHost", "your_proxy_name");
        System.getProperties().put("http.proxyPort", "80");
        // OR
        String urlString = "http://example.com";
        String proxyIP = "your_proxy_ip";
        int portNumber = 80;

        URL server = new URL(urlString);
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyIP, portNumber));
        URLConnection conn = server.openConnection(proxy);
    }
    public static void main(String[] args) {
    }
}