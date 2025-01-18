import org.glassfish.jersey.server.ResourceConfig;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("/*") // This will serve the RESTful service on localhost:8081/yourAppName
public class HelloResourceConfig extends ResourceConfig {
    public HelloResourceConfig() {
        packages("your.example.resources.package"); // Register your resource with JAX-RS Application subclass.
    }
    
    public static void main(String[] args) {
    }
}