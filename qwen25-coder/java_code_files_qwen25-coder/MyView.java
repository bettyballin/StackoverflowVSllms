import java.lang.String;
import java.lang.Set;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.part.ViewPart;

public class MyView extends ViewPart {

    @Override
    public void createPartControl(Composite parent) {
        IToolBarManager toolBarManager = getViewSite().getActionBars().getToolBarManager();

        Action myAction = new Action() {
            {
                setText("My Button");
                setToolTipText("Perform an action");
                setId(getClass().getName());
                setImageDescriptor(MyActivator.getImageDescriptor("icons/my_icon.png")); // Set your icon
            }

            @Override
            public void run() {
                System.out.println("Button clicked!");
            }
        };

        toolBarManager.add(myAction);
        toolBarManager.update(true);
    }

    @Override
    public void setFocus() {
        // Focus to the view part's control.
        Display.getDefault().getActiveShell().setFocus();
    }

    public static void main(String[] args) {
    }
}

class MyActivator {
    public static ImageDescriptor getImageDescriptor(String path) {
        // Return a dummy ImageDescriptor for compilation purposes
        return ImageDescriptor.getMissingImageDescriptor();
    }
}