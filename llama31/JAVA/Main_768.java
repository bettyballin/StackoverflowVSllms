import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.ToolBarLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.jface.action.ToolBarManager;

public class Main_768 {
    public static void main(String[] args) {
        // Create a new display
        Display display = new Display();

        // Create a new shell
        Shell shell = new Shell(display);

        // Create a toolbar manager
        ToolBarManager toolBarManager = new ToolBarManager(SWT.NONE);

        // Create a toolbar
        ToolBar toolBar = toolBarManager.createControl(shell);

        // Create a toolbar item
        ToolItem item = new ToolItem(toolBar, SWT.PUSH);
        item.setText("Button Text");
        // You need to replace "path/to/icon" with the actual path to your icon
        // For simplicity, we will not set an image here

        // Add the item to the toolbar manager
        toolBarManager.add(item);

        // Set the toolbar layout
        toolBar.setLayout(new ToolBarLayout());

        // Update the toolbar
        toolBarManager.update(true);

        // Open the shell
        shell.pack();
        shell.open();

        // Run the event loop
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }
}