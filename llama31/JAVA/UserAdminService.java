import java.lang.String;

// Bad example
public class UserAdminService {
    public void createuser() {}
    public void deleteUser() {}
    public void sendNotification() {}
}

// Good example
class UserCreationService {
    public void createUser() {}
}

class UserDeletionService {
    public void deleteUser() {}
}

public class NotificationService {
    public void sendNotification() {}

    public static void main(String[] args) {
    }
}