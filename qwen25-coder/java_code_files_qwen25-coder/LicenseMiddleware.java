import java.lang.String;
public class LicenseMiddleware {
    private final LicenseService licenseService;

    public LicenseMiddleware(LicenseService licenseService) {
        this.licenseService = licenseService;
    }

    public boolean isAuthorized(String jwtToken) throws Exception {
        // Decode the JWT token to extract user information
        User user = decodeJWT(jwtToken);

        // Check if adding another login attempt would exceed the number of concurrent licenses
        return licenseService.canUserLogin(user.getId());
    }

    private User decodeJWT(String token) {
        // Implementation for decoding JWT and extracting user info
        return new User();
    }
}

class LicenseService {
    public boolean canUserLogin(String userId) {
        // Logic to check the current count of active users VS allowed licenses
        int activeUsers = getActiveUsersCount();
        int allowedLicenses = getAllowedConcurrentLicenses();

        return activeUsers < allowedLicenses;
    }

    private int getActiveUsersCount() {
        // Implement logic to fetch the number of currently logged-in users
        return 0;
    }

    private int getAllowedConcurrentLicenses() {
        // Retrieve the total number of concurrent licenses from a database or configuration
        return 10;
    }

    public static void main(String[] args) {
        // Example usage
        LicenseService licenseService = new LicenseService();
        LicenseMiddleware middleware = new LicenseMiddleware(licenseService);

        try {
            boolean isAuthorized = middleware.isAuthorized("sample_jwt_token");
            System.out.println("Is user authorized? " + isAuthorized);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class User {
    public String getId() {
        return "user-id";
    }
}