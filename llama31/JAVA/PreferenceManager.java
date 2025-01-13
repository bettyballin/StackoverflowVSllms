import java.util.prefs.Preferences;

public class PreferenceManager {
    public static void main(String[] args) {
        Preferences prefs = Preferences.userNodeForPackage(PreferenceManager.class);
        prefs.put("lastOpenedFile", "/path/to/file");
        prefs.flush();
    }
}