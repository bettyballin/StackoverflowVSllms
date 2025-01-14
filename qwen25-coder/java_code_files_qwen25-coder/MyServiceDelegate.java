import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MyServiceDelegate {

    private final RestTemplate restTemplate = new RestTemplate();

    public String getServiceData() {
        return restTemplate.getForObject("http://localhost:8081/service-layer/data", String.class);
    }

    public static void main(String[] args) {
    }
}