import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import java.util.List;

@WebService(name = "UserService", targetNamespace = "http://example.com/users")
@XmlSeeAlso({User.class})
public interface UserService {
    @WebMethod
    @WebResult(name = "users")
    @RequestWrapper(targetNamespace = "http://example.com/users", className = "GetUsersRequest")
    @ResponseWrapper(targetNamespace = "http://example.com/users", className = "GetUsersResponse")
    public List<User> getUsers();
}

class User {
    // Add User class implementation here
}

public class UserService_12Impl implements UserService {
    @Override
    public List<User> getUsers() {
        // Add implementation here
        return null;
    }

    public static void main(String[] args) {
        // Add main method implementation here
    }
}