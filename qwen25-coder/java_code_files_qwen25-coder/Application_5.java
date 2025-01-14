// Example code snippet to initialize an Eclipse RCP application with SWT (a recommended approach)
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

public class Application_5 implements IApplication {
    @Override
    public Object start(IApplicationContext context) throws Exception {
        Display display = PlatformUI.createDisplay();
        Shell shell = new Shell(display);
        shell.setText("My Eclipse RCP App");
        shell.setSize(400, 300);
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        return IApplication.EXIT_OK;
    }

    @Override
    public void stop() {
        if (!PlatformUI.getWorkbench().isClosing()) {
            PlatformUI.getWorkbench().close();
        }
    }

    public static void main(String[] args) {
    }
}