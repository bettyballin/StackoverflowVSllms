import java.io.*;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class MyApp {
    public String getUniqueFileName(String initialPath, String extension) {
        // Create display and shell
        Display display = new Display();
        Shell shell = new Shell(display);

        // Get selected directory from a DirectoryDialog (SWT)
        DirectoryDialog dialog = new DirectoryDialog(shell);
        if (initialPath != null && !initialPath.isEmpty()) {
            dialog.setFilterPath(initialPath);
        }
        String path = dialog.open();

        // Dispose the shell and display
        shell.dispose();
        display.dispose();

        // Generate the unique file name with desired extension using a prefix like "myapp_" and an empty suffix before the extension
        try {
            String tmpFileNamePrefix = "myapp_";
            return File.createTempFile(tmpFileNamePrefix, extension, new File(path)).getName();
        } catch (IOException e) {
            // Handle exception if needed or leave it empty to fail gracefully
        }
        return "";
    }
}