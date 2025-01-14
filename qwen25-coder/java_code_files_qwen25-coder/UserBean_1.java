import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.springframework.beans.factory.annotation.Autowired;

// UserService interface
interface UserService {
    String getCurrentUserName();
}

// A managed bean in JSF
@ManagedBean(name = "userBean")
@RequestScoped
public class UserBean_1 implements Serializable {
    private String name;

    @Autowired
    private UserService userService; // Suppose Spring manages UserService

    public void init() {
        if (userService == null) {
            throw new IllegalArgumentException("User service must not be null");
        }
        name = userService.getCurrentUserName();
    }

    // Getters and setters here...
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
    }
}