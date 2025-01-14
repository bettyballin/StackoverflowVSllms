import java.lang.String;
// Example in Java - Creating a simple SOA governance rule enforcement point
import java.util.Set;

public class ServiceAccessControl {

    public void enforcePolicy(Service service, User user) throws AuthorizationException {
        if (!service.getAuthorizedUsers().contains(user)) {
            throw new AuthorizationException("User is not authorized to access this service.");
        }
        // Proceed with the service call here...
    }

    public static void main(String[] args) {
        // You can add test code here if needed
    }
}

class Service {
    private Set<User> authorizedUsers;

    public Set<User> getAuthorizedUsers() {
        return authorizedUsers;
    }
}

class User {
    // User properties and methods
}

class AuthorizationException extends Exception {
    public AuthorizationException(String message) {
        super(message);
    }
}