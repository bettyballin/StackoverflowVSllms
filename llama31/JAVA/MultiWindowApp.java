import java.lang.String;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;

public class MultiWindowApp {
    public static void main(String[] args) {
        Display display = new Display();
        Monitor[] monitors = display.getMonitors();

        // Create a shell on each monitor
        for (int i = 0; i < monitors.length; i++) {
            Monitor monitor = monitors[i];
            Rectangle bounds = monitor.getBounds();

            Shell shell = new Shell(display, SWT.SHELL_TRIM);
            shell.setText("Window " + i);
            shell.setLocation(bounds.x, bounds.y);
            shell.setSize(400, 300);
            shell.open();
        }

        // Run the event loop
        while (!display.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }
}