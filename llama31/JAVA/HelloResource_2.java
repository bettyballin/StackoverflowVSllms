import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

@ApplicationPath("/rest")
public class RestApplication extends Application {
}

@Path("/hello")
public class HelloResource_2_2 {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello, World!";
    }

    public static void main(String[] args) {
        // You need to run a JAX-RS server to access the resource.
        // You can use a server like GlassFish, Jersey or Apache CXF.
    }
}