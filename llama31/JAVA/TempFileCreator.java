import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

public class TempFileCreator {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File outputDir = chooser.getSelectedFile().getParentFile();
            File tempFile = new File(outputDir, "temp-" + System.currentTimeMillis() + ".tmp");
            try {
                tempFile.createNewFile();
                tempFile.delete();
            } catch (IOException e) {
                // Error message shown to user. Operation is aborted
                System.out.println("Error creating temporary file: " + e.getMessage());
            }
        }
    }
}