import java.util.ArrayList;
import java.util.List;

// Simplified UserViewBean for demonstration
class UserViewBean {
    private String name;
    private int departmentCount;

    public UserViewBean(String name, int departmentCount) {
        this.name = name;
        this.departmentCount = departmentCount;
    }

    public String getName() {
        return name;
    }

    public int getDepartmentCount() {
        return departmentCount;
    }
}

// Data Access Layer (DAO)
class UserDao {
    public List<UserViewBean> getUsersWithDepartmentCount() {
        // Simulate SQL query to retrieve users with department count
        List<UserViewBean> usersWithDepartmentCount = new ArrayList<>();
        usersWithDepartmentCount.add(new UserViewBean("John Doe", 2));
        usersWithDepartmentCount.add(new UserViewBean("Jane Doe", 1));
        return usersWithDepartmentCount;
    }
}

// Service Layer (Controller)
public class UserController {
    private UserDao userDao;

    public UserController() {
        this.userDao = new UserDao();
    }

    public List<UserViewBean> getUsersForScreen() {
        return userDao.getUsersWithDepartmentCount();
    }

    public static void main(String[] args) {
        UserController controller = new UserController();
        List<UserViewBean> users = controller.getUsersForScreen();
        for (UserViewBean user : users) {
            System.out.println("User: " + user.getName() + ", Department Count: " + user.getDepartmentCount());
        }
    }
}