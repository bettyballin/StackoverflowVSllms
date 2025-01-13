import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.jface.window.ApplicationWindow;

public class MyApplication_2 extends ApplicationWindow {
    public MyApplication() {
        super(null);
    }

    @Override
    protected void configureShell(Shell shell) {
        shell.setText("My Application");
    }

    @Override
    protected Control createContents(Composite parent) {
        // Create your UI components here
        Label label = new Label(parent, SWT.NONE);
        label.setText("Hello, World!");
        return label;
    }

    public static void main(String[] args) {
        Display display = new Display();
        MyApplication app = new MyApplication();
        app.setBlockOnOpen(true);
        app.open();
        display.dispose();
    }
}