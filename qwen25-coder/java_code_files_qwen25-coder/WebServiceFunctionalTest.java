import java.lang.String;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import static org.junit.Assert.assertEquals;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebServiceFunctionalTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testWebServiceEndpoint() {
        ResponseEntity<String> response =
                restTemplate.getForEntity("/web-service-endpoint", String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        // Additional assertions can go here based on expected output.
    }

    public static void main(String[] args) {
        // Your code here, if needed
    }
}