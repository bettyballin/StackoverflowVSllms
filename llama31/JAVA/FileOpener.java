import javax.swing.JFileChooser;
import java.io.File;

public class FileOpener {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser("C:/test");
        int returnVal = fileChooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + file.getAbsolutePath());
        } else {
            System.out.println("No file selected");
        }
    }
}