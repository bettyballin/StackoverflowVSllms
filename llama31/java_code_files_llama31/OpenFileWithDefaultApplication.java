/*
 * Decompiled with CFR 0.152.
 */
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OpenFileWithDefaultApplication {
    private static final Logger LOGGER = Logger.getLogger(OpenFileWithDefaultApplication.class.getName());

    public static void openFile(File file) {
        String string;
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().open(file);
                return;
            }
            catch (IOException iOException) {
                LOGGER.log(Level.SEVERE, "Error opening file with Desktop", iOException);
            }
        }
        if ((string = System.getProperty("os.name")).startsWith("Windows")) {
            OpenFileWithDefaultApplication.openFileOnWindows(file);
        } else if (string.startsWith("Linux")) {
            OpenFileWithDefaultApplication.openFileOnLinux(file);
        } else if (string.startsWith("Mac")) {
            OpenFileWithDefaultApplication.openFileOnMac(file);
        }
    }

    private static void openFileOnWindows(File file) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("rundll32.exe", "url.dll,FileProtocolHandler", file.getAbsolutePath());
            processBuilder.start();
        }
        catch (IOException iOException) {
            LOGGER.log(Level.SEVERE, "Error opening file on Windows", iOException);
        }
    }

    private static void openFileOnLinux(File file) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("xdg-open", file.getAbsolutePath());
            processBuilder.start();
        }
        catch (IOException iOException) {
            LOGGER.log(Level.SEVERE, "Error opening file on Linux", iOException);
        }
    }

    private static void openFileOnMac(File file) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("open", file.getAbsolutePath());
            processBuilder.start();
        }
        catch (IOException iOException) {
            LOGGER.log(Level.SEVERE, "Error opening file on Mac", iOException);
        }
    }

    public static void main(String[] stringArray) {
    }
}
