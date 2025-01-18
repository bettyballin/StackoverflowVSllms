import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Main {

    public static void main(String[] args) {
        Display display = new Display(); // Create Display
        Shell shell = new Shell(display); // Create Shell
        Composite mParent = new Composite(shell, SWT.NONE);
        ScrolledComposite scrollBox = new ScrolledComposite(mParent, SWT.V_SCROLL | SWT.H_SCROLL);

        // Adds a bunch of controls here

        mParent.layout();    // Layout the composite first to properly calculate minimum size.

        Point minSize = mParent.computeSize(SWT.DEFAULT, SWT.DEFAULT);  // Get its minimal size.

        scrollBox.setMinSize(minSize.x, minSize.y);   // Set the scrolled composite's minimal size.
        
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }
}