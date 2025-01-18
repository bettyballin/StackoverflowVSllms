import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PartInitException;

public class EclipseViewActivator {

    public static void main(String[] args) {
        IWorkbench wb = PlatformUI.getWorkbench();
        IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
        IWorkbenchPage page = win.getActivePage();
        String viewId = "yourViewIDHere"; // replace with the ID of your Eclipse View
        try {
            IViewPart view = page.showView(viewId);
        } catch (PartInitException e) {
            e.printStackTrace();
        }
    }
}