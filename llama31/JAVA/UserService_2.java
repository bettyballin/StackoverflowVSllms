import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

// Define the User class
class User {
    // Add fields and methods as needed
}

@Path("/users")
public class UserService_2_2 {
    @GET
    @Produces("application/json")
    public List<User> getUsers() {
        // return a list of users
        return null; // Replace with actual implementation
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public User getUser(@PathParam("id") int id) {
        // return a specific user
        return null; // Replace with actual implementation
    }

    @POST
    @Consumes("application/json")
    public void createUser(User user) {
        // create a new user
    }

    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    public void updateUser(@PathParam("id") int id, User user) {
        // update an existing user
    }

    @DELETE
    @Path("/{id}")
    public void deleteUser(@PathParam("id") int id) {
        // delete a user
    }

    public static void main(String[] args) {
        // You may want to add code here to test your UserService_2 class
    }
}