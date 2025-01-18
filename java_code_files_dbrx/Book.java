import com.google.gson.JsonObject;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

public class Book {
    private static OkHttpClient client = new OkHttpClient();

    public static void main(String[] args) throws IOException {
        System.out.println(getTitle("9780465026543", "YOUR_API_KEY"));
    }

    private static String getTitle(String isbn, String apiKey) throws IOException {
        // API endpoint and parameters
        Request request = new Request.Builder()
                .url("https://www.googleapis.com/books/v1/volumes?q=isbn:" + isbn + "&key=" + apiKey)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful())
                throw new IOException("Unexpected code: " + response);

            JsonObject jsonObject = new Gson().fromJson(response.body().charStream(), JsonObject.class);

            // Extract title from the JSON response or return "Title Not Found" if not found
            return jsonObject.getAsJsonArray("items").get(0)
                    .getAsJsonObject().getAsJsonObject("volumeInfo")
                    .has("title") ? jsonObject.getAsJsonArray("items").get(0)
                    .getAsJsonObject().getAsJsonObject("volumeInfo")
                    .get("title").getAsString() : "Title Not Found";
        } catch (IOException e) {
            System.out.println(e);
            return null;
        }
    }
}