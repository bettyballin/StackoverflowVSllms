import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class MyHttpClient {

    public static String call() {
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                AuthScope.ANY,
                new UsernamePasswordCredentials("solutionname", "password"));

        HttpClientContext context = HttpClientContext.create();
        context.setCredentialsProvider(credsProvider);

        try (CloseableHttpClient client = HttpClients.custom().build()) {
            HttpGet getMethod = new HttpGet("https://accesscontrol.windows.net/issuetoken");

            try (CloseableHttpResponse response = client.execute(getMethod, context)) {
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode == HttpStatus.SC_OK) {
                    HttpEntity entity = response.getEntity();
                    return EntityUtils.toString(entity);
                } else {
                    System.out.println("Status Code: " + statusCode);
                    System.out.println("Response: " + EntityUtils.toString(response.getEntity()));
                }
            }
        } catch (Exception e) {
            System.err.println("Error while calling AccessControl portal:");
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String result = call();
        if (result != null) {
            System.out.println("Response: " + result);
        }
    }
}