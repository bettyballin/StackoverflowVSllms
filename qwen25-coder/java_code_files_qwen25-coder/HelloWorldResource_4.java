import java.lang.String;

// Define the necessary annotations since javax.ws.rs.* is not available
@interface GET {}

@interface Path {
    String value();
}

@interface Produces {
    String value();
}

@Path("/hello")
public class HelloWorldResource_4 {
    @GET
    @Produces("text/plain")
    public String getHello() {
        return "Hello, World!";
    }

    public static void main(String[] args) {
    }
}