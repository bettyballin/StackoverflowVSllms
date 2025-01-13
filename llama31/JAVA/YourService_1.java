import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/your/path")
public class YourService_1_1 {
    @GET
    public String yourMethod() {
        // Add your implementation here
        return "Hello, World!";
    }

    public static void main(String[] args) {
        // You can't run a JAX-RS service directly from a main method.
        // You would typically deploy this to a Java EE server or use a framework like Jersey.
        // For the sake of compilation, this main method is left empty.
    }
}