import java.lang.String;

// Assuming GenericDAO and CrudController are in the same package or imported
class GenericDAO<T> {
    public GenericDAO(Session session, Class<T> clazz) {}
}

class CrudController {
    public CrudController(UserDAO dao) {}
}

class Session {}

class User {}

public class UserDAO_8_8 extends GenericDAO<User> {
    public UserDAO_8(Session session) {
        super(session, User.class);
    }
}

public class UserController extends CrudController {
    public UserController(UserDAO_8 dao) {
        super(dao);
    }

    public static void main(String[] args) {
        // Create instances to make the code executable
        Session session = new Session();
        UserDAO_8 dao = new UserDAO_8(session);
        UserController controller = new UserController(dao);
    }
}