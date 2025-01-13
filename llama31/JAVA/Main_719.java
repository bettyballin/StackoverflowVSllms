import java.net.ProxySelector;
import java.net.URI;
import java.net.Proxy;
import java.util.List;

public class Main_719 {
    public static void main(String[] args) throws Exception {
        ProxySelector selector = ProxySelector.getDefault();
        URI uri = new URI("http://example.com");
        List<Proxy> proxies = selector.select(uri);

        // Use the first proxy in the list
        if (!proxies.isEmpty()) {
            Proxy proxy = proxies.get(0);
            System.out.println(proxy);
        } else {
            System.out.println("No proxies found.");
        }
    }
}