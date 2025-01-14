import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class LocalPageDisplay {
    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setLayout(new FillLayout());

        Browser browser = new Browser(shell, SWT.NONE);
        
        // Assuming your HTML file is named "localpage.html"
        String htmlFilePath = LocalPageDisplay.class.getResource("localpage.html").getFile();
        String url = "file://" + htmlFilePath;

        browser.setUrl(url);

        shell.setSize(800, 600);
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }

        display.dispose();
    }
}