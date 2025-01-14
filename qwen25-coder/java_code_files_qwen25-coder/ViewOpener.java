import java.lang.String;

public class ViewOpener {

    public static void showMyView() {
        try {
            // Get the active workbench window's page
            IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

            if (page != null) {
                // Show the view, "my.view.id" is the ID you defined in your plugin.xml for your view
                page.showView("my.view.id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        showMyView();
    }
}

// Stubs for missing classes to allow compilation
class PlatformUI {
    public static IWorkbench getWorkbench() {
        return new IWorkbench();
    }
}

class IWorkbench {
    public IWorkbenchWindow getActiveWorkbenchWindow() {
        return new IWorkbenchWindow();
    }
}

class IWorkbenchWindow {
    public IWorkbenchPage getActivePage() {
        return new IWorkbenchPage();
    }
}

class IWorkbenchPage {
    public void showView(String id) {
        System.out.println("Showing view: " + id);
    }
}