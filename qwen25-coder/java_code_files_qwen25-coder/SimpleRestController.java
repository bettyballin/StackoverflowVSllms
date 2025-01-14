import java.lang.String;

// For Spring REST annotations and classes
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;

// For SOAP annotations
import javax.jws.WebService;
import javax.jws.WebMethod;

// Example of a simple REST endpoint in Java using Spring Boot
@RestController
@RequestMapping("/api")
class SimpleRestController {

    @GetMapping("/greet")
    public ResponseEntity<String> greet() {
        return ResponseEntity.ok("Hello, REST!");
    }
}

// Define the interface SimpleSoapService
@WebService
interface SimpleSoapService {
    @WebMethod
    String greet();
}

// Example of a SOAP service using JAXB annotations for WSDL generation
@WebService(name = "SimpleSoapService", serviceName = "SimpleSoapService")
public class SimpleSoapServiceImpl implements SimpleSoapService {

    @Override
    @WebMethod(operationName = "greet")
    public String greet() {
        return "Hello, SOAP!";
    }

    public static void main(String[] args) {
    }
}