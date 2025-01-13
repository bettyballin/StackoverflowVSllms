import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class EmployeeApiClient {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://www.business.com/Employees")
                .header("Authorization", "Bearer <AccessKey>")
                .build();

        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }
}