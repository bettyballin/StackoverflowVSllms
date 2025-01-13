import java.lang.String;
import java.awt.FileDialog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.AccessController;
import java.security.PrivilegedAction;

import javax.swing.JFileChooser;

public class FileSaverApplet extends javax.swing.JApplet {
    private FileSaveService fileSaveService;

    public void init() {
        fileSaveService = (FileSaveService) AccessController.doPrivileged(
                new PrivilegedAction<FileSaveService>() {
                    public FileSaveService run() {
                        return new FileSaveService();
                    }
                });
    }

    public void saveFile() {
        // Create a sample file
        byte[] fileContent = "Hello, World!".getBytes();

        // Prompt the user to select a location and file name
        FileDialog fileDialog = new FileDialog(this, "Save File", FileDialog.SAVE);
        fileDialog.setVisible(true);
        String fileName = fileDialog.getFile();
        String directory = fileDialog.getDirectory();

        if (fileName != null && directory != null) {
            File file = new File(directory, fileName);

            // Use the FileSaveService to save the file
            fileSaveService.saveFile(file, fileContent);
        }
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                FileSaverApplet applet = new FileSaverApplet();
                applet.init();
                applet.saveFile();
            }
        });
    }
}

class FileSaveService {
    public void saveFile(File file, byte[] fileContent) {
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(fileContent);
        } catch (IOException e) {
            System.err.println("Error saving file: " + e.getMessage());
        }
    }
}