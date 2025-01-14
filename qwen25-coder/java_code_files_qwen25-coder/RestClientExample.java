import feign.Feign;
import feign.RequestLine;
import feign.gson.GsonDecoder;

public class RestClientExample {

    public static void main(String[] args) {
        MyRestClient client = Feign.builder()
            .decoder(new GsonDecoder())
            .target(MyRestClient.class, "http://example.com");
        
        String response = client.getResource();
        System.out.println(response);
    }
}

interface MyRestClient {
    @RequestLine("GET /resource")
    String getResource();
}