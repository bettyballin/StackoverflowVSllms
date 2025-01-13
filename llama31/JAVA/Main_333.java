import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class Main_333 {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        String clientId = "your_client_id";
        String clientSecret = "your_client_secret";

        String tokenEndpoint = "https://your-api.com/token";
        String grantType = "client_credentials";

        HttpEntity<String> request = new HttpEntity<>(
                String.format("grant_type=%s&client_id=%s&client_secret=%s", grantType, clientId, clientSecret),
                headers);

        String response = restTemplate.postForObject(tokenEndpoint, request, String.class);

        System.out.println(response);
    }
}