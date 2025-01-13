/*
 * Decompiled with CFR 0.152.
 */
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.util.List;

public class Main_719 {
    public static void main(String[] stringArray) throws Exception {
        URI uRI;
        ProxySelector proxySelector = ProxySelector.getDefault();
        List<Proxy> list = proxySelector.select(uRI = new URI("http://example.com"));
        if (!list.isEmpty()) {
            Proxy proxy = list.get(0);
            System.out.println(proxy);
        } else {
            System.out.println("No proxies found.");
        }
    }
}
