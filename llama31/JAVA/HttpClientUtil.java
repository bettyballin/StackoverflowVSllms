import java.lang.String;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.MediaType;

public class HttpClientUtil {
    public static void main(String[] args) throws Exception {
        // Using OkHttp
        OkHttpClient client = new OkHttpClient();
        String data = ""; // Define the data to be sent
        Request request = new Request.Builder()
                .url("http://master-server:8080/process")
                .post(RequestBody.create(MediaType.get("application/json"), data))
                .build();
        Response response = client.newCall(request).execute();
    }
}