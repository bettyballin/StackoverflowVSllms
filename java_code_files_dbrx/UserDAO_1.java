import java.lang.String;

public class UserDAO_1 {
    User userObj = new User();
    Session rtsession = new Session();
    User mergedUser = (User) rtsession.merge(userObj);
    
    public static void main(String[] args) {
    }
}

class User {
}

class Session {
    public Object merge(Object obj) {
        return obj;
    }
}