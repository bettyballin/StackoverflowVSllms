import java.io.*;

public class OpenFileHelper {
    public static boolean openFileForEditing(String filename) {
        String os = System.getProperty("os.name").toLowerCase();

        try {
            ProcessBuilder processBuilder;
            if (os.indexOf("win") >= 0) // for windows
                processBuilder = new ProcessBuilder("cmd", "/c", "start", "", filename);
            else if (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0) { // for unix based systems
                processBuilder = new ProcessBuilder("/usr/bin/xdg-open", filename);
            } else return false; // OS is unknown or missing.

            Process process = processBuilder.start();
            InputStream is = process.getErrorStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = reader.readLine()) != null) {
                System.err.println("Warning: " + line);
            }
        } catch (Exception e) {
            return false; // Failed to open file in editor, probably due to an exception.
        }
        return true;
    }
}