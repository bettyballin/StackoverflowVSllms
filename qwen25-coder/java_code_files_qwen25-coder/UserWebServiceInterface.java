import java.lang.String;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

public class UserWebServiceInterface {

    @WebService(targetNamespace = "http://example.com/services")
    public interface UserService {
        @WebMethod(operationName = "getUserById")
        User getUser(@WebParam(name = "id") int id);
    }

    public static void main(String[] args) {
    }
}

class User {
}