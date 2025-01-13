/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;

public class TempFileCreator {
    public static void main(String[] stringArray) {
        JFileChooser jFileChooser = new JFileChooser();
        int n = jFileChooser.showOpenDialog(null);
        if (n == 0) {
            File file = jFileChooser.getSelectedFile().getParentFile();
            File file2 = new File(file, "temp-" + System.currentTimeMillis() + ".tmp");
            try {
                file2.createNewFile();
                file2.delete();
            }
            catch (IOException iOException) {
                System.out.println("Error creating temporary file: " + iOException.getMessage());
            }
        }
    }
}
