import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;

public class FirefoxProxyModifier {
    public static void main(String[] args) {
        // Locate the prefs.js file in the user's profile directory
        String profileDir = System.getProperty("user.home") + "/.mozilla/firefox/xxxxxxx.default";
        File prefsFile = new File(profileDir, "prefs.js");

        // Read the contents of the prefs.js file
        JSONObject prefs = readPrefs(prefsFile);

        // Modify the proxy settings
        String proxyHost = "localhost";
        int proxyPort = 8080;
        prefs.put("network.proxy.http", proxyHost);
        prefs.put("network.proxy.http_port", proxyPort);

        // Write the updated prefs.js file
        writePrefs(prefsFile, prefs);
    }

    private static JSONObject readPrefs(File prefsFile) {
        try (FileReader reader = new FileReader(prefsFile)) {
            StringBuilder contents = new StringBuilder();
            int ch;
            while ((ch = reader.read()) != -1) {
                contents.append((char) ch);
            }
            return new JSONObject(contents.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writePrefs(File prefsFile, JSONObject prefs) {
        try (FileWriter writer = new FileWriter(prefsFile)) {
            writer.write(prefs.toString(4));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}