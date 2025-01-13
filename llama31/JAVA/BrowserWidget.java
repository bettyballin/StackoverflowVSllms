import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class BrowserWidget {
    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        Browser browser = new Browser(shell, SWT.MOZILLA | SWT.BORDER);
        shell.pack();
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) display.sleep();
        }
        display.dispose();
    }
}