import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RESTClientExample {
    OkHttpClient client = new OkHttpClient();

    String get(String url) throws Exception {
        Request request = new Request.Builder()
                .url(url)
                .build();
        
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static void main(String[] args) {
    }
}