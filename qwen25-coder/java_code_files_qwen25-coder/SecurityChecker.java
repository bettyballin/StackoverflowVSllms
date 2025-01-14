import java.lang.String;
public class SecurityChecker {
    // Example pseudo-code function to check if user can download data
    boolean canUserDownloadData(User user) {
        return user.hasRole(UserRole.VIEWER);
    }

    public static void main(String[] args) {
    }
}

class User {
    public boolean hasRole(UserRole role) {
        // Stub implementation
        return false;
    }
}

enum UserRole {
    VIEWER
}