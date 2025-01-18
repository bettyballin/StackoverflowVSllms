import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpException;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.protocol.HttpContext;
import java.net.InetSocketAddress;

public class ProxyHttpClientCreator {

    public static void main(String[] args) {
        CloseableHttpClient client = createHttpClientWithProxy();
        // You can now use the client to execute HTTP requests
    }

    private static CloseableHttpClient createHttpClientWithProxy() {
        InetSocketAddress httpProxy = new InetSocketAddress("myproxy.com", 9191);

        HttpHost proxy = new HttpHost(httpProxy.getHostName(), httpProxy.getPort());

        HttpRoutePlanner routePlanner = new DefaultProxyRoutePlanner(proxy) {
            @Override
            public HttpRoute determineRoute(HttpHost target, HttpRequest request, HttpContext context) throws HttpException {
                return super.determineRoute(target, request, context);
            }
        };

        RequestConfig requestConfig = RequestConfig.custom().setProxy(proxy).build();

        CloseableHttpClient client = HttpClients.custom()
                                    .setDefaultRequestConfig(requestConfig)
                                    .setRoutePlanner(routePlanner)
                                    .build();

        return client;
    }
}