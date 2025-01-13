import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class MyClient {
    public static void main(String[] args) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("http://example.com/myservlet");
        post.setEntity(new StringEntity("This is the request body", "text/plain", "UTF-8"));
        HttpResponse response = client.execute(post);
        System.out.println(response.getStatusLine().getStatusCode());
    }
}