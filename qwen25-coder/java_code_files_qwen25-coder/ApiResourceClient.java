import feign.Headers;
import feign.RequestLine;

public class ApiResourceClient {

    public interface MyRestClient {

        @RequestLine("GET /api/resource")
        @Headers("Content-Type: application/json")
        String getResource();
    }

    public static void main(String[] args) {
    }
}