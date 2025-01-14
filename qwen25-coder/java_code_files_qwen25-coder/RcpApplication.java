import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.application.WorkbenchAdvisor;

public class RcpApplication {
    public static void main(String[] args) {
        Display display = new Display();
        try {
            PlatformUI.createAndRunWorkbench(display, new ApplicationWorkbenchAdvisor());
        } finally {
            display.dispose();
        }
    }

    private static final class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {
        @Override
        public String getInitialWindowPerspectiveId() {
            return "com.example.rcpapp.perspective";
        }

        @Override
        public void postStartup() {
            IWorkbench workbench = PlatformUI.getWorkbench();
            IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
            if (window != null) {
                // Additional setup code can go here
            }
        }
    }
}