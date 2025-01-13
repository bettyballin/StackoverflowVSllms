import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// Define a simple User class for demonstration
class User {
    private String name;
    private int id;

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}

@Path("/users")
public class UserService_11_11 {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers() {
        // Return a list of users for demonstration
        List<User> users = new ArrayList<>();
        users.add(new User("John Doe", 1));
        users.add(new User("Jane Doe", 2));
        return users;
    }

    public static void main(String[] args) {
        // For the sake of compilation, this main method is kept simple.
        // In a real-world application, you would likely use a framework or
        // a method to start your service.
        System.out.println("This is a simple main method to ensure compilation.");
    }
}