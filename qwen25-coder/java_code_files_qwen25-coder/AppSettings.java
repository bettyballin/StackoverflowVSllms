import java.lang.String;
import java.util.prefs.Preferences;

public class AppSettings {
    private Preferences prefs = Preferences.userNodeForPackage(AppSettings.class);

    public void savePreference(String key, String value) {
        prefs.put(key, value);
    }

    public String readPreference(String key, String defaultValue) {
        return prefs.get(key, defaultValue);
    }

    public static void main(String[] args) {
        AppSettings settings = new AppSettings();
        
        // Save a preference
        settings.savePreference("lastOpenedFile", "/path/to/file.txt");
        
        // Read the same preference back
        String lastOpenedFile = settings.readPreference("lastOpenedFile", "default.file");
        System.out.println("Last opened file: " + lastOpenedFile);
    }
}