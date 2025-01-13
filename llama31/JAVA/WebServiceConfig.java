import java.lang.String;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

// Define a custom exception class
class InvalidRequestException extends RuntimeException {
    public InvalidRequestException(String message) {
        super(message);
    }
}

// Define a data repository interface
@Repository
interface DataRepository {
    // Define a method to find data by ID
    java.util.Optional<Data> findById(Long id);
}

// Define a data class
class Data {
    private Long id;

    // Constructor, getters, and setters
    public Data(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

// Enforce HTTPS and authentication using OAuth2
@Configuration
@EnableResourceServer
public class WebServiceConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.requiresChannel()
                .anyRequest()
                .requiresSecure();
        http.oauth2ResourceServer()
                .jwt();
    }
}

// Define a RESTful web service with input validation and error handling
@RestController
@RequestMapping("/api/data")
public class DataWebService {
    @Autowired
    private DataRepository dataRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Data> getData(@PathVariable Long id) {
        // Input validation
        if (id < 1) {
            throw new InvalidRequestException("Invalid ID");
        }
        Data data = dataRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(data);
    }

    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(WebServiceConfig.class, args);
    }
}