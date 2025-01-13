import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.PartInitException;

public class ShowView {
    public static void main(String[] args) {
        // Assuming you have the view ID as a string
        String viewId = "com.example.myview";

        // Get the active workbench window
        IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

        // Get the active page
        IWorkbenchPage page = window.getActivePage();

        // Show the view
        try {
            page.showView(viewId);
        } catch (PartInitException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }
}