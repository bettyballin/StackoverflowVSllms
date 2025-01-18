import java.lang.String;
import java.lang.annotation.*;

// Definitions of Router, ServerResource, Get
class Router {
    public void attach(String path, Object resource) {
        // Do nothing
    }
}

class ServerResource {
    // Empty
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Get {
    String value() default "";
}

public class MainClass {

    static Router router = new Router();

    static {
        // Create route
        router.attach("/service", new ServiceResource());
    }

    // Sample resource class with GET method
    public static class ServiceResource extends ServerResource {
        @Get("xml")            // Supports different formats: "json", "txt" etc.
        public String doGet() {
            // Your implementation here to return XML or JSON
            // For example via JacksonMapper object - jsonOrXmlService.toXML(object)
            return null; // Added return statement to meet method contract
        }
    }

    public static void main(String[] args) {
        // Your main method implementation
    }
}