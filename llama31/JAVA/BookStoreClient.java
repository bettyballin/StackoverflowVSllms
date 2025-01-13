import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.MediaType;

public class BookStoreClient {
    public static void main(String[] args) throws Exception {
        // Client-side example using Java and the OkHttp library
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.get("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"originalBook\":{\"href\":\"http://mydomain.com/rest/book-stores/1/books/12\"}}");
        Request request = new Request.Builder()
                .url("http://mydomain.com/rest/book-stores/2/books")
                .post(body)
                .build();

        Response response = client.newCall(request).execute();
        String newBookUrl = response.header("Content-Location");
        System.out.println(newBookUrl);
    }
}