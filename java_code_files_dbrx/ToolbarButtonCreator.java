import java.lang.String;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;

public class ToolbarButtonCreator {
    public static void main(String[] args) {
        try {
            Display display = PlatformUI.getWorkbench().getDisplay();
            Shell shell = new Shell(display);
            final ToolBar toolbar;

            // Create the tool bar container.
            toolbar = new ToolBar(shell, SWT.FLAT | SWT.RIGHT);

            /* Your button image should go here in place of 'YourImage.png'.
               The size of your desired Eclipse looking button will depend on this Image size. */
            final Image img = fetchButtonImage("YourImage.png");

            // Create the ToolBar Item (Button) with given PUSH style and image as label
            Button b = new Button(toolbar, SWT.PUSH);
            /* You can change setToolTipText to your desired button tooltip */
            b.setImage(img);
            b.setToolTipText("Custom Eclipse Toolbar Button");

            // Pack & Paint Shell and ToolBar for display
            shell.pack();
            shell.open();
        } catch (Exception e) {
            System.out.println("An error occurred while creating the custom tool bar: " + e);
        }
    }

    private static Image fetchButtonImage(String path) {
        Display display = Display.getCurrent();
        return new Image(display, path);
    }
}