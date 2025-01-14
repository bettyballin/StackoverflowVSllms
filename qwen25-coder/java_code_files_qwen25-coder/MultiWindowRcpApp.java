import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class MultiWindowRcpApp {

    public static void main(String[] args) {
        Display display = new Display();
        Shell shell1 = createShell(display, "Window 1", 0, 0);
        Shell shell2 = createShell(display, "Window 2", 500, 500);

        while (!shell1.isDisposed() && !shell2.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }

    private static Shell createShell(Display display, String title, int x, int y) {
        Shell shell = new Shell(display);
        shell.setSize(400, 300);
        shell.setLocation(x, y); // Position each window as needed
        shell.setText(title);

        // Initialize UI components here

        shell.open();
        return shell;
    }
}