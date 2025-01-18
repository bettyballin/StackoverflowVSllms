import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.ContentType;
import java.io.IOException;

public class MyHttpPostExample {
    public static void main(String[] args) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            String url = "http://yourserver/endPoint";  // replace with your server URL and endpoint
            HttpPost httppost = new HttpPost(url);
            String jsonObjectBody = null; // Replace jsonObjectBody with a JSON Object or JSON string data to send in request body
            StringEntity se = new StringEntity(jsonObjectBody, ContentType.APPLICATION_JSON);
            httppost.setEntity(se);
            httpclient.execute(httppost);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpclient.close(); // Make sure it gets closed down
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}