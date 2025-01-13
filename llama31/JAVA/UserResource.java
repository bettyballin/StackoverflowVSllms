import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.QueryParam;

@Path("/users")
public class UserResource {
    @GET
    @Produces("application/json")
    public Response getUsers(@QueryParam("name") String name, @QueryParam("age") int age) {
        // Retrieve users based on query parameters
        List<User> users = userRepository.findUsersByNameAndAge(name, age);
        return Response.ok(users).build();
    }

    public static void main(String[] args) {
    }
}