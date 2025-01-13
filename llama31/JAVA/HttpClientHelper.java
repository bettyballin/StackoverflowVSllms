import java.net.URI;
import org.apache.http.client.methods.HttpGet;

public class HttpClientHelper {
    public static void main(String[] args) {
        URI uri = new URI("http://" + ServiceWrapper.SERVER_HOST + ":" + ServiceWrapper.SERVER_PORT + "/list");
        HttpGet get = new HttpGet(uri);
    }
}