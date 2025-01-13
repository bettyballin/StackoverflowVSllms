import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

// Define the User class
class User {
    // Add fields and methods as needed
}

@Path("/users")
public class UserResource_2_2 {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(User user) {
        // Process the user object
        return Response.status(201).entity(user).build();
    }

    public static void main(String[] args) {
    }
}