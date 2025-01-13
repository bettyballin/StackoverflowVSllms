import java.util.Arrays;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

@WebService
public interface UserService {
  @WebMethod
  List<User> getUsers();
}

class User {
  private int id;
  private String name;

  public User(int id, String name) {
    this.id = id;
    this.name = name;
  }
}

@WebService(endpointInterface = "UserService")
public class UserServiceImpl implements UserService {
  @Override
  public List<User> getUsers() {
    // Return a list of users
    return Arrays.asList(new User(1, "John Doe"), new User(2, "Jane Doe"));
  }
}

public class Server {
  public static void main(String[] args) {
    JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
    factory.setServiceClass(UserServiceImpl.class);
    factory.setAddress("http://localhost:8080/userService");
    factory.create();
  }
}