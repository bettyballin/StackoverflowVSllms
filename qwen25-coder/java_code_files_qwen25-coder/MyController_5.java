import java.util.HashMap;
import java.util.Map;
// Example handling in Java with Spring Boot

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
public class MyController_5 {

    @GetMapping("/example")
    public ResponseEntity<Map<String, Object>> getExample(@RequestHeader(value = "X-Accept-Status", required = false) String acceptStatus) {
        boolean canHandle200Only = "200".equals(acceptStatus);
        Map<String, Object> response = new HashMap<>();
        
        // Simulate a resource not found error
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        String message = "Resource not found.";

        if (canHandle200Only) {
            response.put("status", httpStatus.value());
            response.put("message", httpStatus.getReasonPhrase());
            response.put("data", message); // Or any other relevant data
            return ResponseEntity.ok(response);
        } else {
            return new ResponseEntity<>(response, httpStatus);
        }
    }

    public static void main(String[] args) {
    }
}