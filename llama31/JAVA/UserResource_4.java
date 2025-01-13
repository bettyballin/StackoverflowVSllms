import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

// Assuming User and UserService classes are defined elsewhere
@Path("/users")
public class UserResource_4 {
    private UserService userService;

    public UserResource() {
        this.userService = new UserService(); // Initialize userService
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        // Return a list of users in JSON format
        List<User> users = userService.getUsers();
        return Response.ok(users).build();
    }

    public static void main(String[] args) {
        // You would typically use a framework like Jersey to deploy this resource
        // This is a very simple and not recommended way to make this code executable
        UserResource resource = new UserResource();
        Response response = resource.getUsers();
        System.out.println(response.getEntity());
    }
}

// Assuming User and UserService classes are defined like this
class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class UserService {
    public List<User> getUsers() {
        // Simulating some data
        return List.of(new User("John"), new User("Alice"));
    }
}