import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
public class UserResource_1_1 {
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(@QueryParam("name") String name, @QueryParam("surname") String surname) {
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        
        // Process the user object
        return Response.status(201).entity(user).build();
    }

    public static void main(String[] args) {
    }
}

class User {
    private String name;
    private String surname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}