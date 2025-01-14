import java.lang.String;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.auth.AuthScope;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.HttpHost;

public class ProxyConfigExample {
    public static CloseableHttpClient getHttpClient(String proxyHost, int proxyPort, String proxyUser, String proxyPass) {
        HttpHost proxy = new HttpHost(proxyHost, proxyPort);
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                new AuthScope(proxy.getHost(), proxy.getPort()),
                new UsernamePasswordCredentials(proxyUser, proxyPass));

        return HttpClients.custom()
                .setDefaultCredentialsProvider(credsProvider)
                .setProxy(proxy)
                .build();
    }

    public static void main(String[] args) {
    }
}