import java.lang.String;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

public class XacmlRequest {
    public static void main(String[] args) throws Exception {
        String pdpUrl = "http://localhost:8082/authzforce-ce/pap-pdp-api/app1/decision";
        RestTemplate restTemplate = new RestTemplate();
        // Prepare XACML request and get response...
        ResponseEntity<String> xacmlResponse = restTemplate.postForEntity(pdpUrl, prepareXacmlRequest(), String.class);
        System.out.println(xacmlResponse.getBody());
    }

    private static String prepareXacmlRequest() {
        // Implement this method to prepare the XACML request
        return "<Request>...</Request>";
    }
}