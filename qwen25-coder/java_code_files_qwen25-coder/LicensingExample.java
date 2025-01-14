import com.caucho.lic.*;
import java.util.*;

public class LicensingExample {
    public static void main(String[] args) {
        try {
            // Initialize the license manager
            LicContext context = new LicContext("license.key");

            // Query for a specific feature in your license
            String featureName = "my_feature";
            boolean isFeatureAvailable = context.query(featureName);

            if (isFeatureAvailable) {
                System.out.println("License feature '" + featureName + "' is available.");
            } else {
                System.out.println("License feature '" + featureName + "' is NOT available.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}