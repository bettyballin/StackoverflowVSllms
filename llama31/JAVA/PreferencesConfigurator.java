import java.lang.String;

public class PreferencesConfigurator {
    static {
        System.setProperty("java.util.prefs.PreferencesFactory", "FilePreferencesFactory");
    }

    public static void main(String[] args) {
    }
}