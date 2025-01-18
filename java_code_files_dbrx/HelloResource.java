import java.lang.String;

@Path("/hello")
public class HelloResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello, RESTful service!";
    }

    public static void main(String[] args) {
    }
}

// Stubs for missing classes and annotations

@interface Path {
    String value();
}

@interface GET {
}

@interface Produces {
    String[] value();
}

class MediaType {
    public static final String TEXT_PLAIN = "text/plain";
}