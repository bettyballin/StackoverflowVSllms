import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpRequestExecutor {

    public String executeRequest() {
        OkHttpClient client = new OkHttpClient(); // create OKHttp client object
        Request request = new Request.Builder()
                .get()
                .url(ServiceWrapper.SERVER_HOST + "/list")
                .build(); // build the request
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();  // execute and get result string
        } catch (IOException e) {
            throw new RuntimeException("Error : " + e);
        }
    }

    public static void main(String[] args) {
        OkHttpRequestExecutor executor = new OkHttpRequestExecutor();
        String result = executor.executeRequest();
        System.out.println(result);
    }
}

class ServiceWrapper {
    public static final String SERVER_HOST = "http://example.com";
}