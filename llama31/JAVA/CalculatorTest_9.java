import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

public class CalculatorTest_9_9 {
    @Test
    public void testAdd() {
        Calculator calc = new Calculator();
        assertEquals(2, calc.add(1, 1));
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("CalculatorTest_9");
    }
}

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}

class CalculatorEndpointTest {
    @Test
    public void testAddEndpoint() {
        // Set up REST client and endpoint URL
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/calc/add";
        
        // Send request and verify response
        ResponseEntity<Integer> response = restTemplate.getForEntity(url, Integer.class, 1, 1);
        assertEquals(2, response.getBody());
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("CalculatorEndpointTest");
    }
}