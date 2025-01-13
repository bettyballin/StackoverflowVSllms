import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

// Define or import the User class
class User {
    // Add properties and methods as needed
}

@WebService
public interface UserService {
    @WebMethod
    public User getUser(@WebParam(name = "id") Long id);

    @WebMethod
    public User createUser(@WebParam(name = "user") User user);
}

public class UserService_3_3 {
    public static void main(String[] args) {
        // Add code to test the UserService interface
    }
}