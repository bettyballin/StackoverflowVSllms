import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface PreAuthorize {
    String value();
}

class User {
    // User class implementation
}

public class UserService {

    @PreAuthorize("hasRole('ROLE_USER')")
    public User getUser() {
        // method implementation
        return new User();
    }
}