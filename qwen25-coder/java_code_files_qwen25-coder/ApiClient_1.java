import java.lang.String;
import java.io.IOException;
import okhttp3.*;

public class ApiClient_1 {
    private final OkHttpClient client = new OkHttpClient();

    public void sendRequest(String json) throws IOException {
        RequestBody body = RequestBody.create(json, MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .url("..remote_site..")
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            // Process the response
        }
    }

    public void shutdown() throws IOException {
        client.dispatcher().executorService().shutdown();
        client.connectionPool().evictAll();
    }

    public static void main(String[] args) {
    }
}