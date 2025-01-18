import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.graphics.*;

public class MyWindow {

    public static void main(String[] args) {
        Display display = new Display();
        // create main window
        Shell shell = new Shell(display);
        shell.setText("Main Window");
        // (no additional code needed here)
        shell.open();

        // create additional window
        Shell childShell = new Shell(shell, SWT.NONE);
        int style = SWT.SHELL_TRIM | SWT.ON_TOP;
        Monitor[] monitors = display.getMonitors();
        childShell.setLocation(monitors[1].x, monitors[1].y + 50);
        childShell.setSize(300, 200);
        childShell.setText("Additional Window");
        childShell.open();

        // event loop
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }
}