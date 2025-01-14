// Example function to handle resource access checks securely in an MVC framework
public class ResourceController_5 {

    public ResponseEntity<String> getResource(String resourceId) {
        if (!isResourceExists(resourceId) || !isUserAuthorized(resourceId)) {
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
        // Return the resource content here
        return new ResponseEntity<>("Resource content", HttpStatus.OK);
    }

    private boolean isResourceExists(String resourceId) {
        // Check if the resource exists in your data store
        return true; // or false based on actual check
    }

    private boolean isUserAuthorized(String resourceId) {
        // Check if the user has access rights to this resource
        return false; // or true based on actual authorization logic
    }

    public static void main(String[] args) {
        ResourceController_5 controller = new ResourceController_5();
        ResponseEntity<String> response = controller.getResource("someResourceId");
        System.out.println("Response status: " + response.getStatusCode());
        System.out.println("Response body: " + response.getBody());
    }
}

class ResponseEntity<T> {
    private T body;
    private HttpStatus statusCode;

    public ResponseEntity(T body, HttpStatus statusCode) {
        this.body = body;
        this.statusCode = statusCode;
    }

    public T getBody() {
        return this.body;
    }

    public HttpStatus getStatusCode() {
        return this.statusCode;
    }
}

enum HttpStatus {
    OK(200),
    NOT_FOUND(404);

    private int code;

    HttpStatus(int code) {
        this.code = code;
    }

    public int value() {
        return this.code;
    }
}