import java.lang.String;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OpenFileWithDefaultApplication {
    private static final Logger LOGGER = Logger.getLogger(OpenFileWithDefaultApplication.class.getName());

    public static void openFile(File file) {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().open(file);
                return;
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "Error opening file with Desktop", e);
            }
        }

        String osName = System.getProperty("os.name");
        if (osName.startsWith("Windows")) {
            openFileOnWindows(file);
        } else if (osName.startsWith("Linux")) {
            openFileOnLinux(file);
        } else if (osName.startsWith("Mac")) {
            openFileOnMac(file);
        }
    }

    private static void openFileOnWindows(File file) {
        try {
            ProcessBuilder pb = new ProcessBuilder("rundll32.exe", "url.dll,FileProtocolHandler", file.getAbsolutePath());
            pb.start();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error opening file on Windows", e);
        }
    }

    private static void openFileOnLinux(File file) {
        try {
            ProcessBuilder pb = new ProcessBuilder("xdg-open", file.getAbsolutePath());
            pb.start();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error opening file on Linux", e);
        }
    }

    private static void openFileOnMac(File file) {
        try {
            ProcessBuilder pb = new ProcessBuilder("open", file.getAbsolutePath());
            pb.start();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error opening file on Mac", e);
        }
    }

	public static void main(String[] args) {
	}
}