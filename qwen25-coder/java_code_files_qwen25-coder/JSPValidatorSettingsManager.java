import java.util.prefs.Preferences;

public class JSPValidatorSettingsManager {
    // This is just a conceptual representation.
    // In Eclipse, you typically adjust settings via GUI preferences as described above.

    public JSPValidatorSettingsManager() {
        Preferences prefs = Preferences.userRoot().node("org.eclipse.wst.jsp.core");
        boolean jspValidatorActive = prefs.getBoolean("jsp", true);
        if (!jspValidatorActive) {
            prefs.putBoolean("jsp", true); // Enable JSP validation
        }
    }

    public static void main(String[] args) {
        new JSPValidatorSettingsManager();
    }
}