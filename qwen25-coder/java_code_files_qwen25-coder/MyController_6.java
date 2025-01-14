import java.lang.String;
// Example in Java using Spring MVC

@RestController
public class MyController_6 {

    @GetMapping("/protected-resource")
    public ResponseEntity<String> getProtectedResource() {
        // Assume isUserAuthenticated returns false if the user is not authenticated
        boolean isAuthenticated = isUserAuthenticated();

        if (!isAuthenticated) {
            return new ResponseEntity<>("Authentication required", HttpStatus.UNAUTHORIZED);
        }

        // Return protected resource here
        return new ResponseEntity<>("This is a protected resource", HttpStatus.OK);
    }

    private boolean isUserAuthenticated() {
        // Dummy implementation for compilation purposes
        return false;
    }

    public static void main(String[] args) {
        // You can test the getProtectedResource method here if needed
    }
}

// Dummy annotations and classes to make the code compile

@interface RestController {}

@interface GetMapping {
    String value();
}

class ResponseEntity<T> {
    private T body;
    private HttpStatus status;

    public ResponseEntity(T body, HttpStatus status) {
        this.body = body;
        this.status = status;
    }
}

enum HttpStatus {
    OK,
    UNAUTHORIZED
}