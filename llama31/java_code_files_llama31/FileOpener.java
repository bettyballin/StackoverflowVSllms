/*
 * Decompiled with CFR 0.152.
 */
import java.io.File;
import javax.swing.JFileChooser;

public class FileOpener {
    public static void main(String[] stringArray) {
        JFileChooser jFileChooser = new JFileChooser("C:/test");
        int n = jFileChooser.showOpenDialog(null);
        if (n == 0) {
            File file = jFileChooser.getSelectedFile();
            System.out.println("Selected file: " + file.getAbsolutePath());
        } else {
            System.out.println("No file selected");
        }
    }
}
