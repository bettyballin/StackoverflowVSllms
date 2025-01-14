import java.lang.String;
import java.util.prefs.Preferences;

public class StartupCheck {
    public static void main(String[] args) {
        Preferences userPrefs = Preferences.userRoot().node("<YourCompany>/<YourApp>");
        boolean disableAutoStart = userPrefs.getBoolean("DisableAutoStart", false);

        if (!disableAutoStart) {
            // Proceed with the application startup
        } else {
            System.exit(0); // Exit the program as auto-start is disabled for this user.
        }
    }
}