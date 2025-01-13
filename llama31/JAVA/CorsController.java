import java.lang.String;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

public class CorsController {
    @GetMapping("/endpoint")
    public ResponseEntity<String> endpoint(@RequestHeader("Origin") String origin) {
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.add("Access-Control-Allow-Origin", origin);
        responseHeader.add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
        responseHeader.add("Access-Control-Allow-Headers", "Content-Type");

        return ResponseEntity.ok().headers(responseHeader).body("Response body");
    }

    public static void main(String[] args) {
    }
}