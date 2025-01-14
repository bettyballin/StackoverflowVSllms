import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRouteException;
import org.apache.http.impl.DefaultBHttpClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.SystemDefaultRoutePlanner;
import org.apache.http.protocol.HttpContext;

import java.net.ProxySelector;

public class HttpClientWithProxy {
    public static void main(String[] args) {
        // Define the proxy details
        HttpHost proxy = new HttpHost("myproxy.com", 9191);

        // Create a custom route planner that uses the defined proxy
        SystemDefaultRoutePlanner routePlanner = new SystemDefaultRoutePlanner(
                ProxySelector.getDefault()) {
            @Override
            public HttpRoute determineRoute(final HttpHost target,
                                            final HttpRequest request,
                                            final HttpContext context) throws HttpRouteException {
                return new HttpRoute(target, null, proxy, false);
            }
        };

        // Create an HttpClient with the custom route planner
        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(new DefaultBHttpClientConnectionManager())
                .setRoutePlanner(routePlanner)
                .build();

        // Use httpClient to make requests...
    }
}