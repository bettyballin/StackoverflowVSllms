import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloWorldResource_2_2 {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello, World!";
    }

    public static void main(String[] args) {
        // For this to work as a standalone application, you would need an embedded server
        // like Grizzly or Jetty. However, without implementing a server, this main method
        // is essentially non-functional for testing the resource directly.
    }
}