import java.io.*;
import java.security.*;
import javax.swing.JOptionPane;
import java.util.*;

final class FilePermissionCheck implements PrivilegedAction<File> {
    private final String pathName;

    public FilePermissionCheck(String pathName) {
        this.pathName = pathName;
    }

    @Override
    public File run() {
        try {
            return new File(pathName);
        } catch (AccessControlException ex) {
            throw new SecurityException("Access to file: " + pathName + ": permission denied");
        }
    }
}

public class HighScoreApplet extends java.applet.Applet {
    // your applet code here..
    public void writeToFile() {
        String name = ""; // get the value of name from somewhere..
        Integer score = 0; // get the value of score from somewhere..
        if (name == null || score == null)
            return;
        File output = AccessController.doPrivileged(new FilePermissionCheck("/path-to/highscore.txt"));
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(output, true)); // appends to the file
            writer.println("Name:" + name + " Score: " + score);
        } catch (FileNotFoundException ex) {
            System.err.println("Unable to locate file");
            JOptionPane.showMessageDialog(null, "An error occurred:\n\t" + ex.toString(), "Error!",
                    JOptionPane.ERROR_MESSAGE);
        } catch (SecurityException ex) { // AccessControlException can be converted to SecurityException
            System.err.println("Unable to access file");
            throw new RuntimeException(ex);
        } catch (IOException e) {
            System.err.println("Unable to write to file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
    }
}