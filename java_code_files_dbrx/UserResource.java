import java.lang.String;

@interface Path {
    String value();
}

@Path("/users")
public class UserResource {
    // Define methods for manipulating users here (GET, POST, etc.)

    public static void main(String[] args) {
    }
}