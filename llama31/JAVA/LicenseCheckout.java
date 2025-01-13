import com.nitrolm.LicenseManager;

public class LicenseCheckout {
    public static void main(String[] args) {
        // Initialize NitroLM
        LicenseManager licenseManager = new LicenseManager();

        // Check out a license
        licenseManager.checkOutLicense("your_license_name", "your_user_name");
    }
}