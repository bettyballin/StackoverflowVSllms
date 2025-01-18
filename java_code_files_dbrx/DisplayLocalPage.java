import java.lang.String;
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class DisplayLocalPage {
    public static void main(String[] args) {
        final Display display = new Display();
        Shell shell = new Shell(display);
        FillLayout fillLayout = new FillLayout(); // setting layout to FillLayout to cover whole available space in shell
        shell.setLayout(fillLayout);
        Browser browser = new Browser(shell, SWT.MOZILLA);
        String url = "file://" + System.getProperty("user.dir") + "/"; // constructing URL for the file present at same directory as java class
        try {
            browser.setUrl(url + "MyLocalPage.html"); // set local html page to Browser widget

        } catch (SWTError e) {
            System.out.println("Could not load url:" + e); // handling SWTError by printing error msg
        }
        shell.setText("Loading Local Page using Java Swing");
        shell.setSize(800, 600); // setting size of our application window
        shell.open(); // opening the display to see output
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        browser.dispose();
        display.dispose();
    }
}