import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import java.io.IOException;

public class HttpRequestSenderorJsonRequestSender {
    OkHttpClient client = new OkHttpClient();
    Request request = new Request.Builder()
            .url("https://myserver/mypath") // replace url with your service's URL
            .header("Content-Type", "application/json; charset=utf-8")
            .build();

    public HttpRequestSenderorJsonRequestSender() {
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                // error handling here
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    String body = response.body().string(); // process the data received as needed by your application.
                } else {
                    throw new IllegalStateException("Unexpected code"); // error handling here
                }
            }
        });
    }

    public static void main(String[] args) {
        new HttpRequestSenderorJsonRequestSender();
    }
}