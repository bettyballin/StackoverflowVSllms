import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.HttpClient; // Added import for HttpClient
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients; // Added import for HttpClients
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class JavaFormSubmit {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();  // create a default client instance

        HttpPost postRequest = new HttpPost("https://your-form-action.com");   // replace with your form action url
        List<NameValuePair> parameters = new ArrayList<>();
        parameters.add(new BasicNameValuePair("firstname", "John"));  // add parameters to be sent with the request
        parameters.add(new BasicNameValuePair("lastname", "Doe"));
        postRequest.setEntity(new UrlEncodedFormEntity(parameters));
        postRequest.setHeader("Referer", "https://your-referer.com");  // replace with your referer url

        CloseableHttpResponse response = httpClient.execute(postRequest);

        try {
            System.out.println(response.getStatusLine());  // print the status line for debugging purpose
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity);   // get the result as a string
                System.out.println(result);    // print it out or do whatever you want to do with it
            }
        } finally {
            response.close();
        }
    }
}