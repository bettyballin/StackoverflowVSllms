import com.license4j.LicenseManager;

public class Main_558 {
    public static void main(String[] args) {
        // Initialize License4J
        LicenseManager licenseManager = new LicenseManager();

        // Check out a license
        licenseManager.checkOutLicense("your_license_name", "your_user_name");
    }
}