import java.lang.String;
import javax.ws.rs.*;
import javax.xml.bind.annotation.XmlRootElement;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

@Path("UserService")  // the URL path for the RESTful service is /userservice
public class UserService_2 {
    @POST
    @Consumes("application/json")   // consuming JSON data from HTTP body in request
    public void createUser(User user) {
        System.out.println("\n\tCreating user...");
        System.out.println("\tName: " + user.getName());
        System.out.println("\tSurname: " + user.getSurname() + "\n");
    }

    public static void main(String[] args) {
    }
}

public class User {
    private String name;
    private String surname;

    public User() {
        // Default constructor
    }

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}