import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Main {
    public static void main(String[] args) {
        // Create the Display
        Display display = new Display();
        // Create the Shell
        Shell shell = new Shell(display);

        // Create a parent composite (normally you would have a Display and Shell, but kept minimal here)
        Composite parent = new Composite(shell, SWT.NONE);

        // Create mParent composite
        Composite mParent = new Composite(parent, SWT.NONE);

        // Layout the parent again, after adjusting its components.
        parent.layout();

        // And re-calculate mParent size.
        mParent.setSize(mParent.computeSize(SWT.DEFAULT, SWT.DEFAULT));

        // Open the shell
        shell.open();

        // Event loop to keep the application running until the shell is closed
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) display.sleep();
        }
        display.dispose();
    }
}