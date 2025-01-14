import java.lang.String;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

public class ResourceController_3 {

    @GetMapping(value = "/resource", produces = {
        MediaType.APPLICATION_JSON_VALUE, 
        MediaType.APPLICATION_XML_VALUE
    })
    public ResponseEntity<Resource> getResource() {
        // method implementation
        return new ResponseEntity<Resource>();
    }

    public static void main(String[] args) {
    }
}

// Define the GetMapping annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface GetMapping {
    String value();
    String[] produces();
}

// Define the MediaType class
class MediaType {
    public static final String APPLICATION_JSON_VALUE = "application/json";
    public static final String APPLICATION_XML_VALUE = "application/xml";
}

// Define the ResponseEntity class
class ResponseEntity<T> {
    // Constructor
    public ResponseEntity() {
    }
}

// Define the Resource class
class Resource {
    // Empty class
}