import java.applet.Applet;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrustedApplet extends Applet {
    public void init() {
        // Get the current operating system
        String osName = System.getProperty("os.name");

        // Check if we're on Mac OSX
        if (osName.equals("Mac OS X")) {
            try {
                // Execute a system command using Runtime.exec()
                Process process = Runtime.getRuntime().exec("ls -l");
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.err.println("Error executing command: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        TrustedApplet applet = new TrustedApplet();
        applet.init();
    }
}