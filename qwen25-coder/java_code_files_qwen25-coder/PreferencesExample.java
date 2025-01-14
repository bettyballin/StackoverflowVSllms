import java.util.Set;
public class PreferencesExample {
    public static void main(String[] args) {
        // Set system properties to use file-based preferences
        System.setProperty("java.util.prefs.PreferencesFactory", "com.sun.java.util.prefs.FilePreferencesFactoryImpl");
        System.setProperty("java.util.prefs.userRoot", System.getProperty("user.home") + "/myapp/prefs.xml");
        System.setProperty("java.util.prefs.systemRoot", System.getProperty("java.io.tmpdir") + "/system_prefs.xml");

        // Example usage of Preferences
        java.util.prefs.Preferences prefs = java.util.prefs.Preferences.userNodeForPackage(PreferencesExample.class);
        prefs.put("username", "exampleUser");
        String username = prefs.get("username", "defaultUsername");

        System.out.println("Username stored: " + username);
    }
}