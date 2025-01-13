import java.io.IOException;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class WebClientExample {

    public static void main(String[] args) throws IOException {
        // Create a new client
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // Create a new GET request
        HttpGet request = new HttpGet("https://www.awebsite.com/login");

        // Add parameters to the request
        // Since we're using GET, we'll add parameters to the URL
        // If we were using POST, we'd add them to the request body
        String username = "your_username";
        String password = "your_password";
        request.setHeader("username", username);
        request.setHeader("password", password);

        // Execute the request
        CloseableHttpResponse response = httpClient.execute(request);

        // Write the response to the console
        HttpEntity entity = response.getEntity();
        EntityUtils.consume(entity);
        System.out.println(EntityUtils.toString(entity));

        // Close the client
        httpClient.close();
    }
}