/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileBrowser {
    public static void main(String[] stringArray) {
        JFileChooser jFileChooser = new JFileChooser();
        FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("Text files", "txt");
        jFileChooser.setFileFilter(fileNameExtensionFilter);
        int n = jFileChooser.showOpenDialog(null);
        if (n == 0) {
            File file = jFileChooser.getSelectedFile();
            System.out.println("Selected file: " + file.getAbsolutePath());
        }
    }
}
