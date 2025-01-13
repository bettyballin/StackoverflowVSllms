import java.util.List;
import java.util.ArrayList;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

// Define the User class
class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

// Define the UserService interface
@WebService
public interface UserService {
    @WebMethod
    public List<User> getUsers();
}

// Implement the UserService interface
public class UserServiceImpl_3 implements UserService {
    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "John Doe"));
        users.add(new User(2, "Jane Doe"));
        return users;
    }
}

// Main class to create the SOAP server
public class SOAPServer {
    public static void main(String[] args) {
        JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
        factory.setServiceClass(UserServiceImpl.class); // changed to UserServiceImpl
        factory.setAddress("http://localhost:8080/users");
        factory.create();
    }
}