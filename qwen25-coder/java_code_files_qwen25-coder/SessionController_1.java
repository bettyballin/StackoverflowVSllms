import java.lang.String;

// Define custom annotations
@interface PostMapping {
    String value();
}

@interface GetMapping {
    String value();
}

@interface RequestBody {}

// Define ResponseEntity class
class ResponseEntity<T> {
    public T body;
    public int status;

    private ResponseEntity(T body, int status) {
        this.body = body;
        this.status = status;
    }

    public static <T> ResponseEntity<T> ok(T body) {
        return new ResponseEntity<T>(body, 200);
    }

    public static <T> ResponseEntityBuilder<T> status(int status) {
        return new ResponseEntityBuilder<T>(status);
    }

    public static class ResponseEntityBuilder<T> {
        private int status;

        public ResponseEntityBuilder(int status) {
            this.status = status;
        }

        public ResponseEntity<T> body(T body) {
            return new ResponseEntity<T>(body, status);
        }
    }
}

// Define HttpStatus
class HttpStatus {
    public static final int UNAUTHORIZED = 401;
    public static final int FORBIDDEN = 403;
}

// Define HttpSession
interface HttpSession {
    void setAttribute(String name, Object value);
    Object getAttribute(String name);
}

// Define HttpServletRequest
interface HttpServletRequest {
    HttpSession getSession();
}

public class SessionController_1 {
    // Example pseudo-code for managing a simple session-based web service

    private HttpServletRequest request;

    public SessionController_1(HttpServletRequest request) {
        this.request = request;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserCredentials credentials) {
        if (authenticate(credentials)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", loadUserDetails(credentials.getUsername()));
            return ResponseEntity.ok("Login successful");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }

    @GetMapping("/data")
    public ResponseEntity<String> getProtectedData(HttpSession session) {
        if (session.getAttribute("user") == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Not authenticated");
        }
        // Return data
        return ResponseEntity.ok("Secure Data");
    }

    private boolean authenticate(UserCredentials credentials) {
        // Implement authentication logic here
        return true; // For demo purposes
    }

    private User loadUserDetails(String username) {
        // Implement user loading logic here
        return new User(username); // For demo purposes
    }

    public static void main(String[] args) {
        // Testing the methods
        HttpServletRequest request = new MockHttpServletRequest();
        SessionController_1 controller = new SessionController_1(request);

        UserCredentials credentials = new UserCredentials();
        credentials.username = "user";
        credentials.password = "pass";

        ResponseEntity<String> response = controller.login(credentials);

        System.out.println("Login response: " + response.body);

        HttpSession session = request.getSession();

        response = controller.getProtectedData(session);

        System.out.println("Data response: " + response.body);
    }
}

// Additional classes

class UserCredentials {
    public String username;
    public String password;

    public UserCredentials() {}

    public String getUsername() { return username; }
    public String getPassword() { return password; }
}

class User {
    private String username;

    public User(String username) { this.username = username; }
    public String getUsername() { return username; }
}

// Mock implementations
class MockHttpSession implements HttpSession {
    private java.util.HashMap<String, Object> attributes = new java.util.HashMap<>();

    public void setAttribute(String name, Object value) {
        attributes.put(name, value);
    }
    public Object getAttribute(String name) {
        return attributes.get(name);
    }
}

class MockHttpServletRequest implements HttpServletRequest {
    private HttpSession session = new MockHttpSession();

    public HttpSession getSession() {
        return session;
    }
}