import java.lang.String;

public class WorkbenchConfigurerUtil {
    IWorkbenchConfigurer configurer;

    public WorkbenchConfigurerUtil() {
        configurer = getWorkbenchConfigurer();
        configurer.setShowMenuIcons(false);
    }

    public static void main(String[] args) {
        new WorkbenchConfigurerUtil();
    }

    // Assuming IWorkbenchConfigurer and getWorkbenchConfigurer() are defined elsewhere
    // If not, you'll need to define them or import the correct package
    // For example, if using Eclipse APIs:
    // import org.eclipse.ui.application.IWorkbenchConfigurer;
    // private IWorkbenchConfigurer getWorkbenchConfigurer() {
    //     // implementation to get the configurer
    // }
}