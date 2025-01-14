import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class FormSubmitExample {
    public static void main(String[] args) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost("https://URL_OF_FORM_ACTION");

            // Add the form parameters
            List<BasicNameValuePair> params = new ArrayList<>();
            params.add(new BasicNameValuePair("firstName", "John"));
            params.add(new BasicNameValuePair("lastName", "Doe"));

            httpPost.setEntity(new UrlEncodedFormEntity(params));
            httpPost.setHeader("Referer", "URL_OF_REFERRING_PAGE");

            try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    String result = EntityUtils.toString(entity);
                    System.out.println(result);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}