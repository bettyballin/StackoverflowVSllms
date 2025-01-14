import java.lang.String;
// Example of basic license checking in Java (pseudo-code)
public class LicenseChecker {
    public boolean isValidLicense(String licenseKey) {
        // Implement logic to check against registered licenses and expiration dates
        return true; // Simplified check for demonstration purposes
    }

    public static void main(String[] args) {
        LicenseChecker checker = new LicenseChecker();
        String userLicense = "license123";
        if (!checker.isValidLicense(userLicense)) {
            System.out.println("Invalid license!");
        } else {
            System.out.println("License is valid.");
        }
    }
}