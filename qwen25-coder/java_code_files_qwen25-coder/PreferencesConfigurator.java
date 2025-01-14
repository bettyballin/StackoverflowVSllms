import java.lang.String;
public class PreferencesConfigurator {
    static {
        System.setProperty("java.util.prefs.PreferencesFactory", "java.util.prefs.FilePreferencesFactoryImpl");
        System.setProperty("java.util.prefs.userRoot", System.getProperty("user.home") + "/myapp/prefs.xml");
        System.setProperty("java.util.prefs.systemRoot", System.getProperty("java.io.tmpdir") + "/system_prefs.xml");
    }
    public static void main(String[] args) {
    }
}