import java.lang.String;
import java.util.List;
import java.util.ArrayList;
public class LicenseChecker_1 {
    // Example logic for checking floating licenses
    private static final int MAX_USERS = 10;

    public boolean checkFloatingLicense(String userId) {
        List<String> activeUsers = getActiveUsers();
        return activeUsers.size() < MAX_USERS && !activeUsers.contains(userId);
    }

    private List<String> getActiveUsers() {
        // Dummy implementation
        return new ArrayList<String>();
    }

    public static void main(String[] args) {
    }
}