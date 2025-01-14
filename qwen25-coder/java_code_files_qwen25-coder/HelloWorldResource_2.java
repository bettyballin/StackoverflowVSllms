import java.lang.String;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello")
public class HelloWorldResource_2 {
    @GET
    @Produces("text/plain")
    public String getHello() {
        return "Hello, World!";
    }

    public static void main(String[] args) {
    }
}

// Mock definitions for the annotations
@interface GET {}

@interface Path {
    String value();
}

@interface Produces {
    String value();
}